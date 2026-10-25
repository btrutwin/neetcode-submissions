class Solution {
    

    public int numIslands(char[][] grid) {
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == '1' && visited[r][c] == false){
                    islands++;
                    dfs(grid, visited, r, c);
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, boolean[][] visited, int r, int c){
        int rows = grid.length;
        int cols = grid[0].length;
        if(r < 0 || r >= rows || c < 0 || c >= cols){ // if out of bounds, return
            return;
        }
        if(grid[r][c] == '0' || visited[r][c] == true){ // return if water or already visited
            return;
        }
        visited[r][c] = true;
        // now we have an in bounds cell that isn't water. continue dfs until no more land found
        dfs(grid, visited, r + 1, c); // down 1 
        dfs(grid, visited, r - 1, c); // up 1
        dfs(grid, visited, r, c + 1); // right 1
        dfs(grid, visited, r, c - 1); // left 1

    }
}
