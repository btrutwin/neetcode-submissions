class KthLargest {
    int k;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for(int i = 0; i < nums.length; i++){
            add(nums[i]);
        }
        
    }

    public int add(int val) {
        if(minHeap.size() < k){
        minHeap.add(val);
    }
    else if(val > minHeap.peek()){
        minHeap.poll();
        minHeap.add(val);
    }
        return minHeap.peek();
    }
}