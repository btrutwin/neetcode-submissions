class Solution {
    public int longestConsecutive(int[] nums) {
        int currSeq = 0;
        int longestSeq = 0;
       HashSet<Integer> elements = new HashSet<>();
       if(nums.length == 1){
        longestSeq = 1;
        return longestSeq;
       }
       for(int i = 0; i < nums.length; i++){
        elements.add(nums[i]);
       }
       // Check if nums[i] - 1 is in set
       // if yes, skip
       // if no, start counting. Search for nums[i] + 1 and increment current sequence if found
       // once sequence is complete, compare to longest seq, and update if current > longest
       // 2,20,4,10,3,4,5
       for(int i = 0; i < nums.length; i++){
        if(elements.contains(nums[i] - 1)){
            continue;
        }
        
        else{
            boolean loopBreak = true;
            int seqNumber = nums[i];
            currSeq = 1;
            // need to keep looping while we can find nums[i] + 1
            while(loopBreak == true){
                if(elements.contains(seqNumber + 1) == true){
                    currSeq++;
                    seqNumber++;
                    if(currSeq > longestSeq){
                        longestSeq = currSeq;
                    }
                }
                else{
                    if(currSeq > longestSeq){
                        longestSeq = currSeq;
                    }
                    loopBreak = false;
                }
            }
        }
        
       }
       return longestSeq;
    }
}
