class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        if (stones.length == 0) {
            return 0;
        }
        if (stones.length == 1) {
            return stones[0];
        }
        for(int i = 0; i < stones.length; i++){
           maxHeap.add(stones[i]);
        }
        while(maxHeap.size() > 1){
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            if(first - second == 0){
                continue; // both stones destroyed
            }
            if(first > second){
                maxHeap.add(first - second);
            }
            else{
                maxHeap.add(second - first);
            }
        }
        if(maxHeap.isEmpty()){
            return 0;
        }
        else{
            return maxHeap.peek();
        }

    }
}
