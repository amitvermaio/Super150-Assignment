import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOne {
  static int row = 0;
  static int col = 0;
  static void bfs(int[][] mat, int[][] res, int m, int n, int a, int b, int dist) {
    if (a<0 || b<0 || a>=m || b>=n) {
      return;
    }
    if (mat[a][b] == 0) {
      res[row][col] = dist;
      return;
    }
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};
    for (int i=0; i<4; i++) {
      int cur_row = a + dr[i];
      int cur_col = b + dc[i];
      bfs(mat, res, m, n, cur_row, cur_col, dist+1);
    }
  }

  public static void main(String[] args) {
    int[][] mat = {
      {0, 0, 0},
      {0, 1, 0},
      {1, 1, 1}
    };
    int m = mat.length;
    int n = mat[0].length;
    int[][] res = new int[m][n]; 
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (mat[i][j] == 1) {
          row = i;
          col = j;
          bfs(mat, res, m, n, i, j, 0);
        } 
      }
    }

    System.out.println(
      Arrays.deepToString(res)
    );
  }
}
