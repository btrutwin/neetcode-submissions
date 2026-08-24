class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int longestSeq = 0;
        if(nums.length == 0){
            return longestSeq;
        }
        longestSeq = 1;
        int currentSeq = 1;
        // 2,3,4,4,5,10,20
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[i - 1] == 0){
                continue;
            }
            if(nums[i] - nums[i-1] == 1){
                currentSeq++;
                if(currentSeq > longestSeq){
                    longestSeq = currentSeq;
                }
            }
            else{
                currentSeq = 1;
            }

        }
        return longestSeq;
    }
}
