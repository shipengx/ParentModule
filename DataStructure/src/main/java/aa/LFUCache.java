package aa;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;

/*
 * LFU Cache
 * 
 * Design and implement a data structure for Least frequently used (LFU) cache.
 * It should support the following operations: get and put.
 * 
 * get(key) --- get the value (will always be positive) of the key if the key exists in the cache,
 * otherwise return -1.
 * 
 * put(key, value) --- set or insert the value if the key is not already present.
 * When the cache reaches its capacity, it should invalidate the least frequently used item before 
 * inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more 
 * keys that have the same frequency), the least recently used key would be evicted.
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity ?
 * 
 * Example:
 * 
 * LFUCache  cache = new LFUCache (2 capacity)
 * 
 *  cache.put(1,1);
 *  cache.put(2,2);
 *  cache.get(1);     //  returns 1
 *  cache.put(3,3);   //  evicts key 2
 *  cache.get(2);     //  return -1 (not found)
 *  cache.get(3);     //  return 3.
 *  cache.put(4,4);   //  evicts key 1;
 *  cache.get(1);     //  return -1 (not found)
 *  cache.get(3);     //  return 3;
 *  cache.get(4);     //  return 4
 *  
 */

public class LFUCache {
	
	Node head = null;
    final int capacity;
    Map<Integer, Integer> valueMap;
    Map<Integer, Node> nodeMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        valueMap = new HashMap<>(this.capacity, 1f);
        nodeMap  = new HashMap<>(this.capacity, 1f);
    }
    
    public int get(int key) {
        if (valueMap.containsKey(key)) {
            increase(key, valueMap.get(key));
        }
        return valueMap.getOrDefault(key, -1);
    }
    
    private void increase(int key, int value) {
        Node node = nodeMap.get(key);
        node.keys.remove(key);
        if (Objects.isNull(node.next)) node.next = new Node(node, null, 1 + node.count, key);
        else if (node.next.count == node.count + 1) node.next.keys.add(key);
        else node.next = node.next.prev = new Node(node, node.next, node.count + 1, key);
        nodeMap.put(key, node.next);
        valueMap.put(key, value);
        if (node.keys.isEmpty()) remove(node);
    }
    
    private void remove(Node node) {
        if (head == node) head = node.next;
        else node.prev.next = node.next;
        if (Objects.nonNull(node.next)) node.next.prev = node.prev;
    }
    
    public void put(int key, int value) {
        if (0 == this.capacity) return;
        if (valueMap.containsKey(key)) {
            increase(key, value);
        } else {
            if (valueMap.size() == this.capacity) remove();
            valueMap.put(key, value);
            add(key);
        }
    }
    
    private void add(int key) {
        if (Objects.isNull(head)) head = new Node(null, null, 1, key);
        else if (head.count == 1) head.keys.add(key);
        else head = head.prev = new Node(null, head, 1, key);
        nodeMap.put(key, head);
    }

    private void remove() {
        if (Objects.isNull(head)) return;
        int oldest = head.keys.iterator().next();
        head.keys.remove(oldest);
        if (head.keys.isEmpty()) remove(head);
        nodeMap.remove(oldest);
        valueMap.remove(oldest);
    }
    
    class Node {
        public Node prev, next;
        public final int count;
        public LinkedHashSet<Integer> keys = new LinkedHashSet<>();

        public Node(Node prev, Node next, int count, int key) {
            this.prev = prev;
            this.next = next;
            this.count = count;
            keys.add(key);
        }
    }
    
}
