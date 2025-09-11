package Graph;

import java.util.Arrays;
// ===========================================
// ####### BFS-BACKTRACKING APPROACH ########
// ===========================================

class Solution {
    public int[][] nearest(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        // Step 1: Initialize queue with all 1s
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    res[i][j] = 0;
                    q.add(new int[]{i, j});
                } else {
                    res[i][j] = -1; // not visited yet
                }
            }
        }

        // Directions
        int[] dr = {0, 1, 0, -1, 0};

        // Step 2: BFS
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];

            for (int k=0; k<4; k++) {
                int nr = r + dr[k];
                int nc = c + dr[k+1];

                if (nr>=0 && nc>=0 && nr<m && nc<n && res[nr][nc] == -1) {
                    res[nr][nc] = res[r][c] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        return res;
    }
}




// ===========================================
// ####### DFS-BACKTRACKING APPROACH ########
// ===========================================
/* 
public class DistanceOfNearestCellHaving1 {
  static int row = 0;
  static int col = 0;

  static void findOne(int[][] grid, boolean[][] visited, int a, int b, int m, int n, int dist, int[][] res) {
    if (a<0 || b<0 || a>=m || b>=n || visited[a][b]) {
      return;
    }

    if (grid[a][b] == 1) {
      if (res[row][col] == 0) res[row][col] = 1000;
      res[row][col] = Math.min(res[row][col], dist);
      return;
    } 


    visited[a][b] = true;
    int[] dr = {0, 1, 0, -1, 0};

    for (int i=0; i<4; i++) {
      int curr_row = a + dr[i];
      int curr_col = b + dr[i+1];
      if (res[row][col] == 1) break;
      findOne(grid, visited, curr_row, curr_col, m, n, dist+1, res);
    }

    visited[a][b] = false;
  }

  public static void main(String[] args) {
    int[][] grid = {
      {1, 0, 1},
      {1, 1, 0},
      {1, 0, 0},
    };
    int m = grid.length;
    int n = grid[0].length;
    int[][] res = new int[m][n];
    boolean[][] visited = new boolean[m][n];
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (grid[i][j] == 0) {
          row = i;
          col = j;
          findOne(grid, visited, i, j, m, n, 0, res);
        }
      }
    }
    System.out.println(Arrays.deepToString(res));
  }
  
}
*/