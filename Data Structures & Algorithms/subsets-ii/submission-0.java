class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, new ArrayList<Integer>(), nums);
        return result; 
    }

    private void backtrack(int index, ArrayList<Integer> path, int[] nums){
        if(index == nums.length){
            result.add(new ArrayList<>(path));
            return; 
        }

        // first decision, add the number, then explore the next index
        path.add(nums[index]);
        backtrack(index + 1, path, nums);

        // next decision: remove last element and explore next number that's not the same as nums[index]

        path.remove(path.size() - 1);
        int i = index + 1;
        while(i < nums.length && nums[index] == nums[i]){
            i++;
        }
        backtrack(i, path, nums);
    }
}
