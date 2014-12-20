package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

 class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if (node == null)
    		return node;
    	HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    	LinkedList<UndirectedGraphNode> nodes = new LinkedList<UndirectedGraphNode>();
    	HashSet<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
    	nodes.add(node);
    	while (!nodes.isEmpty()) {
    		UndirectedGraphNode cur = nodes.poll();
    		visited.add(cur);
    		UndirectedGraphNode copNode;
    		if (!mapping.containsKey(cur)) {
    			copNode = new UndirectedGraphNode(cur.label);
        		mapping.put(cur, copNode);
    		} else
    			copNode = mapping.get(cur);
    		
    		for(UndirectedGraphNode n : cur.neighbors) {
    			UndirectedGraphNode cn;
    			if (mapping.containsKey(n))
    				cn = mapping.get(n);
    			else {
    				cn = new UndirectedGraphNode(n.label);
    				mapping.put(n, cn);
    			}
    			copNode.neighbors.add(cn);
    			if (!visited.contains(n)) {
    				nodes.add(n);
    				visited.add(n);
    			}

    		}
    	}
    	return mapping.get(node);
    }
}
