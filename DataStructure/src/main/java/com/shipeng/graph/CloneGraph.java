package com.shipeng.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * Clone graph
 * 
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * Nodes are labeled uniquely.
 * 
 */

public class CloneGraph {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		
		UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
		
		queue.add(node);
		map.put(node, newHead);
		
		while(!queue.isEmpty()) {
			UndirectedGraphNode curr = queue.remove();
			List<UndirectedGraphNode> currNeighbors = curr.neighbors;
			
			for (UndirectedGraphNode aNeighbor : currNeighbors) {
				if (!map.containsKey(aNeighbor)) {
					UndirectedGraphNode copy = new UndirectedGraphNode(aNeighbor.label);
					map.put(aNeighbor, copy);
					map.get(curr).neighbors.add(copy);
					queue.add(aNeighbor);
				}else {
					map.get(curr).neighbors.add(map.get(aNeighbor));
				}
			}
		} //end while
		
		return newHead;
		
	}
}
