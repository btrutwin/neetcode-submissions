class Solution {
    public int search(int[] nums, int target) {
        // need to have left and right ptr 
        // take average of them. check nums mid and adjust ptrs as needed 
        int left = 0; int right = nums.length - 1; 
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
