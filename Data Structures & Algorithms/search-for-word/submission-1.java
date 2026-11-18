class Solution {
    public boolean exist(char[][] board, String word) {
        // use this to loop through matrix to find start
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (search(i, j, board, visited, 0, word) == true) {
                        return true;
                    }
                }
            }
        }
        return false; // never had search return true
    }

    private boolean search(
        int i, int j, char[][] board, boolean[][] visited, int index, String word) {
        // Base case: index == word.length. Found all letters in word
        if (index == word.length()) {
            return true;
        }

        // only continue to search if index is valid, and we haven't visited it
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] == true
            || board[i][j] != word.charAt(index)) {
            return false;
        }
        // now have a valid index that has the current char we're looking for. Mark as visited, then
        // search up, down, left right

        visited[i][j] = true;

        boolean found = 
        search(i - 1, j, board, visited, index + 1, word)
            || search(i + 1, j, board, visited, index + 1, word)
            || search(i, j - 1, board, visited, index + 1, word)
            || search(i, j + 1, board, visited, index + 1, word);

        visited[i][j] = false; // never found
        return found; 
    }
}
