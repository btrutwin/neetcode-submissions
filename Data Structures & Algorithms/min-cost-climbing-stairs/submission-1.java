class Solution {
    
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length + 1];
        Arrays.fill(memo, -1);

        return dp(cost, memo, cost.length);
    }

    private int dp(int[] cost, int[] memo, int i) {
    if (i == 0 || i == 1) {
        return 0;
    }

    if(memo[i] != -1){
        return memo[i];
    }

    int i1 = dp(cost, memo, i - 1) + cost[i - 1];
    int i2 = dp(cost, memo, i - 2) + cost[i - 2];
    memo[i] = Math.min(i1, i2);

    return memo[i];

    // TODO 1: If we already solved this state,
    // return the saved answer.

    // TODO 2: Calculate the cost of reaching i
    // from i - 1.

    // TODO 3: Calculate the cost of reaching i
    // from i - 2.

    // TODO 4: Save and return the minimum.
}


}
