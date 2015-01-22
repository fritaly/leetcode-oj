package com.github.fritaly.leetcode;

import java.util.Set;
import java.util.TreeSet;

public class SetMatrixZeroes {

	public void setZeroes(int[][] matrix) {
		final Set<Integer> rows = new TreeSet<>();
		final Set<Integer> columns = new TreeSet<>();

		for (int y = 0; y < matrix.length; y++) {
			for (int x = 0; x < matrix[y].length; x++) {
				if (matrix[y][x] == 0) {
					rows.add(y);
					columns.add(x);
				}
			}
		}

		for (Integer y : rows) {
			for (int x = 0; x < matrix[y].length; x++) {
				matrix[y][x] = 0;
			}
		}
		for (Integer x : columns) {
			for (int y = 0; y < matrix.length; y++) {
				matrix[y][x] = 0;
			}
		}
	}
}