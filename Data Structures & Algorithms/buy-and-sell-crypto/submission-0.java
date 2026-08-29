class Solution {
    public int maxProfit(int[] prices) {
        // loop through prices, keep track of min price seen
        // if there is a price greater than min price, compute min - prices[i] as max 
        // continue looping until end and return max profit. 0 if none found
        int max = 0;
        int min = prices[0];
        // [10,1,5,6,7,1]
        for(int i = 0; i < prices.length - 1; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            int profitNow = prices[i + 1] - min;
            if(profitNow > max){
                max = profitNow;
            }
        }
        return max; 
        
    }
}
