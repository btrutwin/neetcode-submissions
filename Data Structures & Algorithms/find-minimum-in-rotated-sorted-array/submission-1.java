class Solution {
    public int findMin(int[] nums) {
        // give array of length n that was sorted ascending. Has been rotated between 1 and n times
        // return the minimum element of the array 
        // needs to be o(log n)
        // [3,4,5,6,1,2] take right, left, and mid. 
        // if mid > right, we know that the break happens in that segment
        // if mid < right, we know all numbers right of mid are ascending and don't need to check there 
        int right = nums.length - 1; int left = 0;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[right]){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
