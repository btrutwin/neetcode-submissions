class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, new ArrayList<>(), nums);
        return result; 
    }

    private void backtrack(int index, List<Integer> path, int[] nums){
        // start with base case. If index = nums.length, add to result and return 
        if(index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        // first decision, add the next number 
            path.add(nums[index]);
            backtrack(index + 1, path, nums);
        
        
        // undo last decision and explore next 

        path.remove(path.size() - 1);
        backtrack(index + 1, path, nums);
    }
}
