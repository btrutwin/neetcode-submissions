class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    int rows; int cols;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length; 
        cols = heights[0].length; 
        List<List<Integer>> result = new ArrayList<>();

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // DFS to fill both 
        for(int i = 0; i < cols; i++){ // fill in sea level trues for pacific
            dfs(heights, 0, i, -1, pacific);
        }
        for(int j = 0; j < rows; j++){
            dfs(heights, j, 0, -1, pacific);
        }

        for(int i = 0; i < cols; i++){ // fill in sea level trues for atlantic
            dfs(heights, rows - 1, i, -1, atlantic);
        }
        for(int j = 0; j < rows; j++){
           dfs(heights, j, cols - 1, -1, atlantic);
        }

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(pacific[r][c] == true && atlantic[r][c] == true){
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result; 
    }

    private void dfs(int[][] heights, int r, int c, int prev, boolean[][] ocean){
        rows = heights.length; 
        cols = heights[0].length;
        if(r < 0 || c < 0 || r >= rows || c >= cols){
            return; 
        }
        if(heights[r][c] < prev || ocean[r][c]){
            return; 
        }
        ocean[r][c] = true; 
        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            dfs(heights, nr, nc, heights[r][c], ocean);
        }


    }

}
