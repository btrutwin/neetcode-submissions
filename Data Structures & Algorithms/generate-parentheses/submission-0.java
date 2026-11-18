class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
       backtrack(0,0,"", n);
       return result;
    }

    private void backtrack(int openCount, int closeCount, String currString, int n){
        if(openCount == n && closeCount == n){
            result.add(currString);
            return;
        }

        if(openCount < n){
            String nextPath = currString + "(";
            backtrack(openCount + 1, closeCount, nextPath, n);
        }

        if(closeCount < openCount){
            String nextPath = currString + ")";
            backtrack(openCount, closeCount + 1, nextPath, n);
        }
    }
}
