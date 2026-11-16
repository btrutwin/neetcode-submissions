class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(0, new ArrayList<>(), nums, target, 0);
        return result; 
    }

    private void backtrack(int index, List<Integer> path, int[] nums, int target, int sum){
        // base case, target is found 
        if(sum == target){
            result.add(new ArrayList<>(path));
            return; 
        }
       
        if(index == nums.length || sum > target){
            return; 
        }

        // option 1: add the element of index 
            path.add(nums[index]);
            backtrack(index, path, nums, target, sum + nums[index]);

        // now we've explored all paths with same index. Either have success or not. 
        // remove end of list and explore alternatives
        path.remove(path.size() - 1);
        // exclude current number and move forward
        backtrack(index + 1, path, nums, target, sum);
    }
}

