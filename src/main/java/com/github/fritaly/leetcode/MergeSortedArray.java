package com.github.fritaly.leetcode;

public class MergeSortedArray {

	public void merge(int A[], int m, int B[], int n) {
		final int[] array = new int[m + n];

		int indexA = 0, indexB = 0;

		while ((indexA < m) || (indexB < n)) {
			final Integer a = (indexA < m) ? A[indexA] : null;
			final Integer b = (indexB < n) ? B[indexB] : null;

			if (a == null) {
				array[indexA + indexB] = b;

				indexB++;
			} else if (b == null) {
				array[indexA + indexB] = a;

				indexA++;
			} else {
				if (a < b) {
					array[indexA + indexB] = a;

					indexA++;
				} else {
					array[indexA + indexB] = b;

					indexB++;
				}
			}
		}

		for (int i = 0; i < array.length; i++) {
			A[i] = array[i];
		}
	}
}