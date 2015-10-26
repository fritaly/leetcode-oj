package com.github.fritaly.leetcode;

import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	private StringBuilder serialize(StringBuilder buffer, TreeNode root) {
		if (root != null) {
			buffer.append(root.val);
			buffer.append(",");
			serialize(buffer, root.left);
			buffer.append(",");
			serialize(buffer, root.right);
		} else {
			buffer.append("null");
		}
		
		return buffer;
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		return serialize(new StringBuilder(), root).toString();
	}
	
	private LinkedList<Integer> parse(String data) {
		final LinkedList<Integer> list = new LinkedList<Integer>();
		
		for (String element : data.split(",")) {
			list.add("null".equals(element) ? null : Integer.parseInt(element));
		}
		
		return list;
	}
	
	private TreeNode deserialize(LinkedList<Integer> data) {
		final Integer id = data.removeFirst();
		
		if (id != null) {
			final TreeNode node = new TreeNode(id);

			if (!data.isEmpty()) {
				node.left = deserialize(data);
				node.right = deserialize(data);
			}
			
			return node;
		}
		
		return null;
	}
	
	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		return deserialize(parse(data));
	}
}