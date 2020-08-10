class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length == 0 )
            return 0;
        boolean canSell = false;
        int buyingPrice = prices[0];
        int profit = 0;
        
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < buyingPrice) 
                buyingPrice = prices[i];
            
            if(prices[i] >= buyingPrice )
                profit = Math.max(prices[i] - buyingPrice, profit);
        }
        return profit;
    }
}