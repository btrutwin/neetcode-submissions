class Solution {
    // very similar to number of islands, but now in dfs need to keep track of how large an island is 
    // instead of how many there are. Have a global variable maxArea keeping track of largest seen area
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length; 
        int cols = grid[0].length;
        int maxArea = 0;
        boolean[][] visited = new boolean[rows][cols];

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 1 && visited[r][c] == false){
                    int area = dfs(grid, visited, r, c);
                    maxArea = Math.max(maxArea,area);
                }
            }
        }
        return maxArea;
    }
     // need to increment every time land is seen within the same island
    private int dfs(int[][] grid, boolean[][] visited, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return 0;
        }

        if (grid[r][c] == 0 || visited[r][c]) {
            return 0;
        }

        visited[r][c] = true;

        int area = 1;
        area += dfs(grid, visited, r - 1, c);
        area += dfs(grid, visited, r + 1, c);
        area += dfs(grid, visited, r, c - 1);
        area += dfs(grid, visited, r, c + 1);

        return area;
    }

}
