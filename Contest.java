public class Contest {
  static void bfs(int[][] arr, int a, int b, int m, int n, boolean[][] visited) {

    if (a<0 || b<0 || a>=m || b>=n || visited[a][b]) return;
    System.out.println(arr[a][b]);
    visited[a][b] = true;
    // System.out.printf("\ncall for Row: %d, Col: %d, Element: %d \n", a, b, arr[a][b]);
    bfs(arr, a, b+1, m, n, visited);
    bfs(arr, a+1, b, m, n, visited);
    bfs(arr, a, b-1, m, n, visited);
    bfs(arr, a-1, b, m, n, visited);
  }

  public static void main(String[] args) {

    int[][] arr = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12}
    };
    int m = arr.length;
    int n = arr[0].length;
    boolean[][] visited = new boolean[m][n];
    bfs(arr, 0, 0, m, n, visited);
  }
}