package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumHeightTrees {
	
	private static class Node {
		final int id;
		
		final Set<Node> neighbors = new HashSet<Node>();
		
		Node(int id) {
			this.id = id;
		}
		
		boolean isLeaf() {
			return (neighbors.size() <= 1);
		}
		
		void detach() {
			for (Node neighbor : neighbors) {
				neighbor.neighbors.remove(this);
			}
			
			neighbors.clear();
		}
	}

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    	final Map<Integer, Node> nodes = new LinkedHashMap<Integer, Node>();
    	
    	for (int i = 0; i < n; i++) {
    		nodes.put(i, new Node(i));
		}
    	
    	for (int i = 0; i < edges.length; i++) {
    		final Node node1 = nodes.get(edges[i][0]);
    		final Node node2 = nodes.get(edges[i][1]);
    		
    		node1.neighbors.add(node2);
    		node2.neighbors.add(node1);
		}

    	final List<Node> allNodes = new ArrayList<Node>(nodes.values());
    	
    	while (true) {
    		final List<Node> leaves = new ArrayList<Node>();
    		
    		for (Node node : allNodes) {
				if (node.isLeaf()) {
					leaves.add(node);
				}
			}
    		
    		for (Node leaf : leaves) {
				leaf.detach();
			}
    		
    		allNodes.removeAll(leaves);
    		
    		if (allNodes.isEmpty()) {
    			final List<Integer> ids = new ArrayList<Integer>();
    			
    			for (Node leaf : leaves) {
					ids.add(leaf.id);
				}
    			
    			return ids;
    		}
    	}
    }
}