package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CloneGraph {

	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}
	
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if (node != null) {
        	final Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        	
        	final LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        	queue.add(node);
        	
        	while (!queue.isEmpty()) {
        		final UndirectedGraphNode source = queue.removeFirst();
            	final UndirectedGraphNode clone = new UndirectedGraphNode(source.label);
            	
            	map.put(source, clone);
            	
            	if (source.neighbors != null) {
            		for (UndirectedGraphNode node2 : source.neighbors) {
    					if (!map.containsKey(node2)) {
    						queue.add(node2);
    					}
    				}
            	}
        	}
        	
        	for (UndirectedGraphNode source : map.keySet()) {
				final UndirectedGraphNode clone = map.get(source);
				
				if (source.neighbors != null) {
					clone.neighbors = new ArrayList<UndirectedGraphNode>();
					
					for (UndirectedGraphNode neighbor : source.neighbors) {
						clone.neighbors.add(map.get(neighbor));
					}
				}
        	}
        	
        	return map.get(node);
    	}

    	return null;
    }
}