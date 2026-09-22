class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Make nums1 the larger array, nums2 the smaller array
        if (nums1.length < nums2.length) {
            int[] placeholder = nums2;
            nums2 = nums1;
            nums1 = placeholder;
        }

        int n1length = nums1.length;
        int n2length = nums2.length;
        int length = n1length + n2length;
        int half = (length + 1) / 2;

        int left = -1;                 // mid can be -1: nums2 contributes 0 elements
        int right = n2length - 1;      // mid can be n2length-1: nums2 contributes all elements

        while (left <= right) {
            int mid = left + (right - left) / 2;  // last index of nums2 in left partition
            int p1left = half - mid - 1;          // first index of nums1 in right partition

            int nums1Left  = (p1left == 0)      ? Integer.MIN_VALUE : nums1[p1left - 1];
            int nums1Right = (p1left == n1length) ? Integer.MAX_VALUE : nums1[p1left];
            int nums2Left  = (mid == -1)        ? Integer.MIN_VALUE : nums2[mid];
            int nums2Right = (mid + 1 == n2length) ? Integer.MAX_VALUE : nums2[mid + 1];

            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                if (length % 2 == 0) {
                    return (Math.max(nums1Left, nums2Left) 
                          + Math.min(nums1Right, nums2Right)) / 2.0;
                } else {
                    return Math.max(nums1Left, nums2Left);
                }
            } else if (nums1Left > nums2Right) {
                // nums1's left part is too big -> need more elements from nums2
                left = mid + 1;
            } else {
                // nums2's left part is too big -> need fewer elements from nums2
                right = mid - 1;
            }
        }

        return 0.0; // unreachable
    }
}