class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(countMap.containsKey(nums[i])){
                countMap.put(nums[i], countMap.get(nums[i]) + 1); 
            }
            else{
                countMap.put(nums[i], 1);
            }
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(countMap.entrySet());
        entries.sort((a,b) -> b.getValue() - a.getValue());
        int[] returnList = new int[k];
        for(int i = 0; i < k; i++){
           returnList[i] = entries.get(i).getKey();
        }
        return returnList;
    }
}
