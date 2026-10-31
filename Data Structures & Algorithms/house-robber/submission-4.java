class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int prev2 = nums[0];  int prev1 = Math.max(prev2, nums[1]);
        if(nums.length == 2){
            return Math.max(prev1, prev2);
        }

        for(int i = 2; i < nums.length; i++){
            int temp = prev1; 
            prev1 = Math.max(prev2 + nums[i], temp);
            prev2 = temp; 
        }

        return prev1;
        
    }
}
