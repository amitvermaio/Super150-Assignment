package Graph;

public class FindWhetherPathExists {
  static boolean bfs(int[][] grid, boolean[][] visited, int a, int b, int d1, int d2, int m, int n) {
      if (a<0 || b<0 || a>=m || b>=n || visited[a][b]) {
          return false;
      }
      if (grid[a][b] == 0) return false;
      if (a==d1 && b==d2) return true;
      visited[a][b] = true;
      
      int[] dr = {0, 1, 0, -1, 0};
      for (int i=0; i<4; i++) {
          int curr_row = a + dr[i];
          int curr_col = b + dr[i+1];
          if (bfs(grid, visited, curr_row, curr_col, d1, d2, m, n)) {
              return true;
          }
      }
      return false;
  }
    
  public boolean is_Possible(int[][] grid) {
      // Code here
      int m = grid.length;
      int n = grid[0].length;
      boolean[][] visited = new boolean[m][n];
      int[] src = new int[2];
      int[] des = new int[2];
      for (int i=0; i<m; i++) {
          for (int j=0; j<n; j++) {
              if (grid[i][j] == 1) {
                  src[0] = i;
                  src[1] = j;
              } else if (grid[i][j] == 2) {
                  des[0] = i;
                  des[1] = j;
              }
          }
      }
      
      return bfs(grid, visited, src[0], src[1], des[0], des[1], m, n);
      
  }
}
