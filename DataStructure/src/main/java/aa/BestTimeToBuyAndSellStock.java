package aa;

/*
 * Best time to buy and sell stock
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * if you were only permitted to complete at most one transaction (ie. buy one and sell one share of stock),
 * design an algorithm to find the maximum profit.
 * 
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * 
 * max.difference = 6-1 = 5 (not 7-1= 6, as selling price needs to be larger than buying price.
 * 
 * Example 2: 
 * input: [7,6,4,3,1]
 * output: 0
 * in this case, no transaction is done, i.e. max profit = 0.
 * 
 */


public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		
		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;
		
		for (int i = 0; i < prices.length; i++) {
			maxProfit = Math.max(maxProfit, prices[i] - minPrice);
			minPrice = Math.min(minPrice, prices[i]);
		}
		
		return maxProfit;
	}
	
}
