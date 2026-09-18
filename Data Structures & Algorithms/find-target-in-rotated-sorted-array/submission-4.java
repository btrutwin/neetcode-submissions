class Solution {
    public int search(int[] nums, int target) {
        // given array of length n that has been rotated
        // need to find target and return its index, or -1 if not present
        // must be O(logn) -- binary
        // similar to smallest num but now looking for the target num
        //[3,4,5,6,1,2] looking for 1. start at right, left and mid
        // mid = 5, right = 2, left = 3
        // if mid == target, return mid
        // if nums[left] < nums[mid], that segment is sorted. If nums[left] < target, target there
        // or not present if nums[left] > nums[mid], that segment is not sorted. If nums[right] >
        // target, between mid and right
        //
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                // left half is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
