class Solution {
    public int rob(int[] nums) {
        // dynamic programming problem 
        // similar to min cost to climb steps, but max now
        // need to be able to make decisions on which house to go to
        // not sure how to do that 
        /* state - nums[i] represents the amount of money you gain from going to that house
        recurrance - dp[i] comes from the total amount of money gained from the path leading up to the 
        house plus the money in the house. Last decision affects which houses we can't go to, since 
        the next house isn't an option anymore 
        Base Case - base case is the first or second house in nums, but can't be both since one eliminates the possibility of us robbing the other 
        Order - fill states left to right 
        answer is the sum of path before last house we rob + amount in that house. 
        \[
dp[i] = \max(dp[i-1],\ dp[i-2] + nums[i])
\]
        */
        if(nums.length == 1){
            return nums[0];
        }
       int prev2 = nums[0]; int prev1 = Math.max(nums[0], nums[1]);

       for(int i = 2; i < nums.length; i++){
        int current = Math.max(prev1, prev2 + nums[i]);
        prev2 = prev1; 
        prev1 = current; 
       }


        return prev1; 
        
    }
}
