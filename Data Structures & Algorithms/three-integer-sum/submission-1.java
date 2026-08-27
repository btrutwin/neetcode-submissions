class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        // loop through nums. need to check everything between left and right before moving i 
        // have while loop since left - right gap isn't fixed 
        // if sum too small, move left, too big, right, if right on, move both
        // duplicates need to be skipped, so need to check that nums[i] > nums[i - 1]

        for(int i = 0; i < nums.length; i++){
            if(i > 0){
                if(nums[i] == nums[i - 1]){
                    continue;
                }
            }
            int left = i + 1;
            int right = nums.length - 1;
           
            // target num is sum - nums[i] == 0
            // [-4,-1,-1,0,1,2]
            // nums[i] = -4, left = 1, right = 5, sum = 1
            while(left < right){
                int sum = nums[left] + nums[right] + nums[i];
                //1 - -5 = 6 > 0
                if(sum < 0){
                    left++;
                }
                else if(sum > 0){
                    right--;
                }
                else{
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]){
                    left++;
                    }
                     while(left < right && nums[right] == nums[right + 1]){
                    right--;
                    }
                }
            }
        }
        

        return result;
    }
}
