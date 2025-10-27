class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                } else {
                    res[i][j] = -1;
                }
            }
        }
        int[] dir = {0, 1, 0, -1, 0};
        while(!q.isEmpty()) {
            int[] arr = q.poll();
            int r = arr[0];
            int c = arr[1];
            for (int i=0; i<4; i++) {
                int nr = r + dir[i];
                int nc = c + dir[i+1];
                if (nr<m && nc<n && nr>=0 && nc>=0 && res[nr][nc]==-1) {
                    res[nr][nc] = res[r][c] + 1;
                    q.add(new int[]{nr, nc});
                }

            }
        }
        return res;
    }
}

public class ZeroOneMatrix {
  
}
