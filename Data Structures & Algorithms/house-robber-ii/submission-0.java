class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int prev2 = nums[0];  int prev1 = Math.max(prev2, nums[1]);
        
        for(int i = 2; i < nums.length -1; i++){
            int temp = prev1; 
            prev1 = Math.max(prev2 + nums[i], temp);
            prev2 = temp; 
        }
        int s1 = prev1; 

        prev2 = nums[nums.length - 1];  prev1 = Math.max(prev2, nums[nums.length - 2]);
        for(int i = nums.length - 3; i > 0; i--){
            int temp = prev1; 
            prev1 = Math.max(prev2 + nums[i], temp);
            prev2 = temp; 
        }
        int s2 = prev1;

        return Math.max(s1,s2);
        
    }
}
