class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];
        for(int i = 0; i < 9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        // check if row Set already contains number. If yes, false, if no, add to set
        // check if col Set already contains number. If yes, false, if no add to set
        // check if box Set already contains number. If yes, false, if no add to set 
        // col Set will be col number. Box set is (row % 3) + 3 * (col % 3)
        for(int col = 0; col < 9; col++){
            for(int row = 0; row < 9; row++){
                int whichBox = (row / 3) + 3 * (col / 3);
                if(board[row][col] == '.'){
                    continue;
                }
                if(rows[col].contains(board[row][col])){
                    return false;
                }
                rows[col].add(board[row][col]);

                if(cols[row].contains(board[row][col])){
                    return false;
                }
                cols[row].add(board[row][col]);

                if(boxes[whichBox].contains(board[row][col])){
                    return false;
                }
                boxes[whichBox].add(board[row][col]);
            }

        }
        return true;
    }
}
