class Solution {
    public int findKthLargest(int[] nums, int k) {
        // create a min heap of size k elements 
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            heap.add(nums[i]);
        }
        // now have min heap with first k elements. top element at end is answer

        for(int i = k; i < nums.length; i++){
            int top = heap.peek();
            int next = nums[i];
            if(next > top){
                heap.poll();
                heap.add(nums[i]);
            }
        }
        return heap.peek();
        
    }
}
