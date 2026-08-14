class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int needed = target - nums[i];
            if(numbers.containsKey(needed)){
                return new int[]{numbers.get(needed), i};
            }
            numbers.put(nums[i], i);
        }
        return new int[]{};
    }
}
