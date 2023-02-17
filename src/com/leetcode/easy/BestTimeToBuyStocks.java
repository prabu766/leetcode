package com.leetcode.easy;

/**
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 * 
 * 
 * Example 1:
 * 
 * Input: prices = [7,1,5,3,6,4] Output: 5 Explanation: Buy on day 2 (price = 1)
 * and sell on day 5 (price = 6), profit = 6-1 = 5. Note that buying on day 2
 * and selling on day 1 is not allowed because you must buy before you sell.
 * 
 * Example 2:
 * 
 * Input: prices = [7,6,4,3,1] Output: 0 Explanation: In this case, no
 * transactions are done and the max profit = 0.
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class BestTimeToBuyStocks {
	public static void main(String[] args) {
		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(prices));
		System.out.println(maxProfitOptimized(prices));
	}

	/**
	 * This is the brute force way
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		int maxProfit = 0;
		for (int i = prices.length - 1; i > 0; --i) {
			if(maxProfit >=  prices[i]) {
				continue;
			}
			for (int j = i - 1; j >= 0; --j) {
				if(prices[i] - prices[j] > maxProfit) {
					maxProfit = prices[i] - prices[j];
				}
				
			}
		}
		return maxProfit;
	}
	
	/**
	 * 
	 * @param prices
	 * @return
	 */
	public static int maxProfitOptimized(int[] prices) {
		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length ; ++i) {
			if(prices[i]<minPrice) {
				minPrice = prices[i];
			}
			//check how much profit can get today, by selling the stocks bought for that minimum price
			int todayProfit = prices[i] - minPrice;
			if(todayProfit > maxProfit) {
				maxProfit = todayProfit;
			}
		}
		return maxProfit;
	}
	
}
