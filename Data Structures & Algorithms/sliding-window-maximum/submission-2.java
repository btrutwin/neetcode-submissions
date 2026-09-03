class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       // create an array of size nums - k to store max in 
       // use a deque to store the indexes of nums 
       // when a new number comes, loop through the deque to find all the indexes that 
       // go to a number that's smaller than the incoming number, and then store the new index
       // once there is a valid window size i - k >= 0, every new number will be added to array 
       // need to make sure that window doesn't contain any indexes < i - k once valid 

        int[] maxWindow = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        // construct first valid window

        for(int i = 0; i < nums.length; i++){
            // remove expired indexes
            while(!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i >= k - 1){
            maxWindow[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return maxWindow;
    }
}
