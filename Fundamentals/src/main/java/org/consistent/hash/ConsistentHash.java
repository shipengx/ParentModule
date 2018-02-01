package org.consistent.hash;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConsistentHash {

	private int numOfVirtualNodes = 5000;
	private SortedMap<Integer, String> hashRing = new TreeMap<Integer, String>();
	private Map<String, Node> servers = new ConcurrentHashMap<String, Node>();
	private Random rnd = new Random(System.currentTimeMillis());

	public ConsistentHash() {
	}

	/**
	 * Does node already exist in the pool
	 * 
	 * @param node
	 *            Node name
	 * @return true or false
	 */
	public Boolean nodeExists(String node) {
		return servers.containsKey(node.toLowerCase());
	}

	public Set<String> getNodes() {
		return servers.keySet();
	}

	/**
	 * Add a node to the pool
	 * 
	 * @param node
	 *            Node name(Unique String)
	 */
	public void add(String node) {
		if (servers.containsKey(node)) {
			System.out.println("node:" + node + " already exists");
			return;
		} else if (!servers.containsKey(node)) {
			servers.put(node.toLowerCase(), new Node(node));
		}

		System.out.println("ConsistentHash adding:" + node + " configured:" + toString());

		synchronized (hashRing) {
			for (int i = 0; i < numOfVirtualNodes; i++) {
				hashRing.put(hash(generateKey(node, i)), node);
			}
		}

	}

	public void remove(String node) {
		removeNodeFromRing(node);
		servers.remove(node);
	}

	private void removeNodeFromRing(String node) {
		synchronized (hashRing) {
			for (int i = 0; i < numOfVirtualNodes; i++) {
				hashRing.remove(hash(generateKey(node, i)));
			}
		}
	}

	private String generateKey(String server, int index) {
		return server + (100000 + index);
	}

	public String get(Long key) throws Exception {
		try {
			if (hashRing.isEmpty()) {
				return null;
			}
			// if the key is null, select a random node
			if (key == null) {
				key = new Long(rnd.nextInt());
			}
			int hash = hash(key);
			if (!hashRing.containsKey(hash)) {
				SortedMap<Integer, String> tailMap = hashRing.tailMap(hash);
				hash = tailMap.isEmpty() ? hashRing.firstKey() : tailMap.firstKey();
			}
			String node = hashRing.get(hash);
			return node;

		} catch (Exception ex) {
			System.out.println("key:" + key + " hashRing:" + hashRing.size());
			throw ex;
		}
	}

	private int hash(Long src) {
		return hashEx(ByteBuffer.allocate(8).putLong(src).array());
	}

	private int hash(String src) {
		return hashEx(src.getBytes());
	}

	private int hashEx(byte[] src) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(src);
			byte[] bytes = md.digest();

			return (bytes[0] & 0xFF) | ((bytes[1] & 0xFF) << 8) | ((bytes[2] & 0xFF) << 16) | ((bytes[3] & 0xFF) << 24);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @return Comma delimited list of distinct servers in the hashRing
	 */
	public String getHashRing() {
		StringBuilder sb = new StringBuilder();
		Set<String> distinctNodes = new HashSet<String>();
		for (Integer key : hashRing.keySet()) {
			String server = hashRing.get(key);
			if (!distinctNodes.contains(server)) {
				if (sb.length() > 0) {
					sb.append(",");
				}
				sb.append(server);
				distinctNodes.add(server);
			}
		}

		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String server : servers.keySet()) {
			if (sb.length() > 0) {
				sb.append(",");
			}
			sb.append(server);
		}
		return "ConsistentHash [numOfVirtualNodes=" + numOfVirtualNodes + ",servers=" + sb.toString() + "]";
	}

	public static void main(String[] args) throws Exception {
		ConsistentHash c = new ConsistentHash();
		c.add("node1");
		c.add("node2");
		c.add("node3");

		String[] servers = new String[] { "google.com", "yahoo.com", "facebook.com" };
		for (int i = 0; i < servers.length; i++) {
			System.out.println(c.get((long) (i)));
		}
	}

}