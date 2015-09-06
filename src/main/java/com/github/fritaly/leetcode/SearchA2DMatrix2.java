package com.github.fritaly.leetcode;

public class SearchA2DMatrix2 {

	public boolean searchMatrix(int[][] matrix, int target) {
		for (int y = 0; y < matrix[0].length; y++) {
			if (matrix[0][y] > target) {
				break;
			}
			
			for (int x = 0; x < matrix.length; x++) {
				final int value = matrix[x][y];
				
				if (value == target) {
					return true;
				} else if (value > target) {
					break;
				}
			}
		}
		
		return false;
	}
}