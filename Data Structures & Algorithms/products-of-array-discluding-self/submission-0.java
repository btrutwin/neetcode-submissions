class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int left = 1;
        for(int i = 0; i < nums.length; i++){
            output[i] = left;
            left = left * nums[i];
        }
        int right = 1;
        for(int i = nums.length - 1; i > -1; i--){
            output[i] = output[i] * right;
            right = right * nums[i];
        }
        return output;
    }
}  
