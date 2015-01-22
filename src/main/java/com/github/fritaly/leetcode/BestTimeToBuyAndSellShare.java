package com.github.fritaly.leetcode;

public class BestTimeToBuyAndSellShare {

	private static class Data {
		int min = Integer.MAX_VALUE;

		int max = Integer.MIN_VALUE;

		int getProfit() {
			return max - min;
		}
	}

	public int maxProfit(int[] prices) {
		if (prices.length <= 1) {
			return 0;
		}

		final Data[] array = new Data[prices.length];

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < prices.length; i++) {
			array[i] = new Data();
			array[i].min = min = Math.min(min, prices[i]);
		}

		int maxProfit = Integer.MIN_VALUE;

		for (int i = prices.length - 1; i >= 0; i--) {
			array[i].max = max = Math.max(max, prices[i]);

			maxProfit = Math.max(maxProfit, array[i].getProfit());
		}

		return maxProfit;
	}
}