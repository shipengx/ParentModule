package bihui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Clone graph
 * 
 * Clone an undirected graph. 
 * Each node in the graph contains a label and a list of its neighbors.
 * 
 * Nodes are labeled uniquely.
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * 
 * The graph has a total of three nodes, and therefore contains three parts as separated by {@link #clone()}.
 * 
 * 1. First node is labeled as 0. Connect the 0 to both nodes 1 and 2.
 * 2. Second node is labeled as 1. Connect the 1 to node 2.
 * 3. Third node is labeled as 2. Connect the 2 to node 2 (itself), thus forming a self-cycle.
 * 
 * Visually, the graph looks like the following:
 * 
 *          1
 *       0     2
 * 
 */

public class CloneGraph {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        queue.add(node);
        map.put(node, newHead);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.pop();
            List<UndirectedGraphNode> curNeighbors = cur.neighbors;
            
            for (UndirectedGraphNode aNeighbor: curNeighbors) {
                if (!map.containsKey(aNeighbor)) {
                    UndirectedGraphNode copy = new UndirectedGraphNode(aNeighbor.label);
                    map.put(aNeighbor,copy);
                    map.get(cur).neighbors.add(copy);
                    queue.add(aNeighbor);
                }else {
                    map.get(cur).neighbors.add(map.get(aNeighbor));
                }
            }
        }
        
        return newHead;
    }
	
}


class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };
