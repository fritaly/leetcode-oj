package com.github.fritaly.leetcode;

import java.util.Arrays;

public class RangeSumQueryMutable {

	public static class NumArray {

		private final int[] array;
		
		private final long[] sumsBefore, sumsAfter;
		
		private long total;

		public NumArray(int[] nums) {
			this.array = nums;
			this.sumsBefore = new long[array.length];
			this.sumsAfter = new long[array.length];

			long sum = 0;

			for (int i = 0; i < array.length; i++) {
				sumsBefore[i] = sum;
				sum += array[i];
			}
			
			this.total = sum;
			
			for (int i = 0; i < array.length; i++) {
				sum -= array[i];
				sumsAfter[i] = sum;
			}
			
			dump();
		}

		private void dump() {
			System.err.println("--- DUMP ---");
			System.err.println("Array: " + Arrays.toString(array));
			System.err.println("Total: " + total);
			System.err.println("Sums before: " + Arrays.toString(sumsBefore));
			System.err.println("Sums after: " + Arrays.toString(sumsAfter));
			System.err.println("---");
		}

		void update(int i, int val) {
			final int delta = (val - array[i]);
			
			array[i] = val;
			
			total += delta;
			
			for (int j = i + 1; j < sumsBefore.length; j++) {
				sumsBefore[j] += delta;
			}
			for (int j = 0; j < i; j++) {
				sumsAfter[j] += delta;
			}
			
			dump();
		}

		public int sumRange(int i, int j) {
			int result = (int) (total - sumsBefore[i] - sumsAfter[j]);
			
			System.err.println(String.format("sumRange(%d, %d) = %d", i, j, result));
			
			return result;
		}
	}

	public static void main(String[] args) {
		 NumArray numArray = new NumArray(new int[] { 1, 3, 5 });
		 numArray.sumRange(0, 2);
		 numArray.update(1, 2);
		 numArray.sumRange(0, 2);
	}
}