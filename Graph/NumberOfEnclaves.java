package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
  static int res;
  static int count = 0;
    
  static boolean bfs(int[][] grid, boolean[][] visited, int r, int c, int m, int n) {
      visited[r][c] = true;
      System.out.println(r + " " + c);
      res++;
      Queue<int[]> q = new LinkedList<>();
      q.add(new int[]{r, c});
      int[] dr = {0, 1, 0, -1, 0};
      
      System.out.println("here is count - "+count++);
      System.out.println("---");


      while (!q.isEmpty()) {
          int[] arr = q.poll();
          int cr = arr[0];
          int cc = arr[1];
          for (int i=0; i<4; i++) {
              int nr = cr + dr[i];
              int nc = cc + dr[i+1];
              if (nr<0 || nc<0 || nr>=m || nc>=n) continue;
              
              if (!visited[nr][nc] && grid[nr][nc]==1) {
                  System.out.println(
                      nr + " " + nc
                  );
                  q.add(new int[]{nr, nc});
                  visited[nr][nc] = true;
                  res++;
              }
          }
      }
      return true;
  }    
  
  int numberOfEnclaves(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      boolean[][] visited = new boolean[m][n];
      int row = 0;
      int col = 0;
      for (int i=0; i<m; i++) {
          for (int j=0; j<n; j++) {
              res = 0;
              if (grid[i][j]==1 && !visited[i][j]) {
                  if (bfs(grid, visited, i, j, m, n)) {
                      row = i;
                      col = j;
                      // System.out.println(row + " " + col);
                      break;
                  }
              }
          }
          if (row!=0 && col!=0) break;
      }
      return res;
  }

  public static void main(String[] args) {
    NumberOfEnclaves obj = new NumberOfEnclaves();
    int[][] grid = {
            {0, 1, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0}
        };
    int res = obj.numberOfEnclaves(grid);
    System.out.println(res);
  }
}
