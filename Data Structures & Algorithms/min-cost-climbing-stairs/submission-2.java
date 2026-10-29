class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev2 = 0;
        int prev1 = 0;

        for (int i = 2; i <= cost.length; i++) {
            int current = Math.min(prev2 + cost[i - 2], prev1 + cost[i - 1]); // dp[i]
            prev2 = prev1;
            prev1 = current;

            
            // Calculate the current minimum cost

            // Shift prev1 into prev2

            // Store current into prev1
        }

        return prev1;
    }
}