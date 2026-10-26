class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int minutes = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    q.add(new int[] {r, c});
                }
                if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int size = q.size();
            boolean hasRotten = false;

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for (int j = 0; j < 4; j++) {
                    int nr = r + dr[j];
                    int nc = c + dc[j];
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                        continue;
                    }
                    if (grid[nr][nc] == 1) {
                        fresh--;
                        hasRotten = true;
                        q.add(new int[] {nr, nc});
                        grid[nr][nc] = 2;
                    }
                }
            }
            if(hasRotten == true){
                minutes++;
            }
        }
        if(fresh == 0){
            return minutes; 
        }
        else{
            return -1;
        }
    }
}
