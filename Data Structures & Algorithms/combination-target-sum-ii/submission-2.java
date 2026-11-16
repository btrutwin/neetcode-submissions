class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(int index, List<Integer> path, int[] candidates, int target, int sum) {
        // for every variable, need to choose whether to add it or move to next. If we're at target,
        // we return and add that combination to result. If sum > target or index >
        // candidates.length, also return

        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        // won't find a valid combination anymore.
        if (sum > target || index == candidates.length) {
            return;
        }

        // Include current candidate
        path.add(candidates[index]);
        backtrack(index + 1, path, candidates, target, sum + candidates[index]);

        // Undo
        path.remove(path.size() - 1);

        // Skip duplicates before excluding
        int i = index + 1;

        while (i < candidates.length && candidates[i] == candidates[index]) {
            i++;
        }

        // Exclude current candidate and its duplicates
        backtrack(i, path, candidates, target, sum);
    }
}
