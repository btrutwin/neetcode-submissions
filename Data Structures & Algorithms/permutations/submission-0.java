class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(0, new ArrayList<>(), nums);
        return result; 
    }

    private void backtrack(int index, ArrayList<Integer> path, int[] nums){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return; 
        }

        for(int i = 0; i < nums.length; i++){
            if(path.contains(nums[i])){
                continue;
            }
            path.add(nums[i]);
            backtrack(index, path, nums);

            path.remove(path.size() - 1);
        }
    }
}