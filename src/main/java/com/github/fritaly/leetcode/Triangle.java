package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {
		List<Integer> previous = null;

		for (List<Integer> line : triangle) {
			final List<Integer> temp = new ArrayList<>(line.size());

			for (int i = 0; i < line.size(); i++) {
				if (i == 0) {
					if (previous != null) {
						temp.add(line.get(i) + previous.get(i));
					} else {
						temp.add(line.get(i));
					}
				} else if (i == line.size() - 1) {
					if (previous != null) {
						temp.add(line.get(i) + previous.get(i - 1));
					} else {
						temp.add(line.get(i));
					}
				} else {
					temp.add(line.get(i) + Math.min(previous.get(i - 1), previous.get(i)));
				}
			}

			System.out.println(temp);

			previous = temp;
		}

		return Collections.min(previous);
	}
}