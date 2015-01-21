package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
    	List<Integer> previous = null;

    	for (int n = 1; n <= rowIndex + 1; n++) {
			final List<Integer> list = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				if ((i == 0) || (i == n - 1)) {
					list.add(1);
				} else {
					list.add(previous.get(i - 1) + previous.get(i));
				}
			}

			previous = list;
		}

    	return previous;
    }
}