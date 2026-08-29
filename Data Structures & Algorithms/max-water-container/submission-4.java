class Solution {
    public int maxArea(int[] heights) {
        // this is a two pointer problem. Move the small height pointer and keep track of max height
        // can be solved in o(n) with one loop 
        // have left ptr and right ptr. take area = height smaller ptr * right - left 
        // whichever ptr is smaller, move 1. keep track of max area and update when better is found 
        int left = 0; 
        int right = heights.length - 1;
        int maxArea = 0;
        while(left < right){
        
            // need to compute if height[left] >,<, == height[right]
            int minHeight = 0;
            if(heights[left] > heights[right]){
                minHeight = heights[right];
            }
            else{
                minHeight = heights[left];
            }
            int area = (right - left) * (minHeight);
            if(area > maxArea){
                maxArea = area;
            }
            if(heights[left] > heights[right]){
                right--;
            }
            else{
                left++;
            }

        }
        
        return maxArea;
        
    }
}
