class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int total = 0;
        // water[i] = Math.min(leftMax, rightMax) - height[i]
        while(left < right){
            // if left is less than right, left has to be the limiting factor
            // check to see if leftMax is < height[left]
            // compute total 
            if(height[left] < height[right]){
                if(height[left] > leftMax){
                    leftMax = height[left];
                }
                total += leftMax - height[left];
                left++;
            }
            else{
                if(height[right] > rightMax){
                    rightMax = height[right];
                }
                total += rightMax - height[right];
                right--;
            }
            
        }
    return total;
}

}
