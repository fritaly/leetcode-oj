package com.github.fritaly.leetcode;

public class BestTimeToBuyAndSellStock2 {
	
    public int maxProfit(int[] prices) {
    	int buyTime = 0, sellTime = 0;
    	int totalProfit = 0;
    	
    	while ((buyTime < prices.length) && (sellTime < prices.length)) {
        	int buyPrice = prices[buyTime];
        	
        	// Select the lowest buy price
        	while (buyTime < prices.length - 1) {
        		if (prices[buyTime + 1] > buyPrice) {
        			break;
        		}
        		
        		buyPrice = prices[++buyTime];
        	}
        	
        	sellTime = buyTime + 1;
        	
        	if (sellTime == prices.length) {
        		break;
        	}
        	
        	int sellPrice = prices[sellTime];
        	
        	// Select the highest sell price
        	while (sellTime < prices.length - 1) {
        		if (prices[sellTime + 1] < sellPrice) {
        			break;
        		}
        		
        		sellPrice = prices[++sellTime];
        	}
        	
        	System.out.println(String.format("BuyTime: %d, SellTime: %d - profit: %d", buyTime, sellTime, sellPrice - buyPrice));
        	
        	// if the profit is negative, just do nothing on that period
        	totalProfit += Math.max(0, sellPrice - buyPrice);
        	
        	buyTime = sellTime + 1;
    	}

    	return totalProfit;
    }
}