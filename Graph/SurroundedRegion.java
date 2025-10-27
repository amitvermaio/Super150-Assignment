class Solution {
    public void solve(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 'O') dfs(grid, i, 0, visited, m, n);
            if (grid[i][n - 1] == 'O') dfs(grid, i, n - 1, visited, m, n);
        }

        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 'O') dfs(grid, 0, j, visited, m, n);
            if (grid[m - 1][j] == 'O') dfs(grid, m - 1, j, visited, m, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                }
            }
        }
    }

    static void dfs(char[][] grid, int r, int c, boolean[][] visited, int m, int n) {
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || grid[r][c] != 'O') return;
        visited[r][c] = true;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            dfs(grid, r + dr[i], c + dc[i], visited, m, n);
        }
    }
}

public class SurroundedRegion {
  
}
