class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount];
        // 1, 2, 5
        if(amount == 0){
            return 0; 
        }
        for(int i = 0; i < coins.length; i++){
            if(coins[i] <= amount){
            dp[coins[i] - 1] = 1; 
            }
        }
        for(int i = 0; i < amount; i++){ 
            int minSteps = Integer.MAX_VALUE;
            if(dp[i] == 1){
                continue;
            }

            for(int j = 0; j < coins.length; j++){
                // checking i = 6 currenty 
                if(i - coins[j] >= 0 && dp[i - coins[j]] != -1){
                    int currSteps = dp[i - coins[j]] + 1;
                    if(currSteps < minSteps){
                    minSteps = currSteps;
                }
                }
                
            }
            if(minSteps == Integer.MAX_VALUE){
                dp[i] = -1;
            }
            else{
                dp[i] = minSteps;
            }
        }

        return dp[amount - 1];
        
    }
}