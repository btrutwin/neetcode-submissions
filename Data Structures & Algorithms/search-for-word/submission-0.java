class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        // Explore every possible starting position
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, visited, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, boolean[][] visited,
                           int i, int j, int index, String word) {

        // Base case: every letter has been found
        if (index == word.length()) {
            return true;
        }

        // Reject invalid states
        if (i < 0 || i >= board.length ||
            j < 0 || j >= board[0].length ||
            visited[i][j] ||
            board[i][j] != word.charAt(index)) {
            return false;
        }

        // Choose
        visited[i][j] = true;

        // Explore all four directions
        boolean found =
            search(board, visited, i - 1, j, index + 1, word) ||
            search(board, visited, i + 1, j, index + 1, word) ||
            search(board, visited, i, j - 1, index + 1, word) ||
            search(board, visited, i, j + 1, index + 1, word);

        // Undo the choice
        visited[i][j] = false;

        return found;
    }
}