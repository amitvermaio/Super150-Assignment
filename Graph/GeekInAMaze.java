class Solution {

    static class State {
        int r, c, up, down;
        State(int r, int c, int up, int down) {
            this.r = r;
            this.c = c;
            this.up = up;
            this.down = down;
        }
    }

    public static int numberOfCells(int n, int m, int r, int c, int u, int d, char mat[][]) {
        if (mat[r][c] == '#') return 0;

        Queue<State> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        visited[r][c] = true;
        q.add(new State(r, c, u, d));

        int count = 0;

        while (!q.isEmpty()) {
            State curr = q.poll();
            count++;

            // Left
            int left = curr.c - 1;
            if (left >= 0 && mat[curr.r][left] == '.' && !visited[curr.r][left]) {
                visited[curr.r][left] = true;
                q.add(new State(curr.r, left, curr.up, curr.down));
            }

            // Right
            int right = curr.c + 1;
            if (right < m && mat[curr.r][right] == '.' && !visited[curr.r][right]) {
                visited[curr.r][right] = true;
                q.add(new State(curr.r, right, curr.up, curr.down));
            }

            // Up
            int up = curr.r - 1;
            if (up >= 0 && mat[up][curr.c] == '.' && curr.up > 0 && !visited[up][curr.c]) {
                visited[up][curr.c] = true;
                q.add(new State(up, curr.c, curr.up - 1, curr.down));
            }

            // Down
            int down = curr.r + 1;
            if (down < n && mat[down][curr.c] == '.' && curr.down > 0 && !visited[down][curr.c]) {
                visited[down][curr.c] = true;
                q.add(new State(down, curr.c, curr.up, curr.down - 1));
            }
        }

        return count;
    }
}


public class GeekInAMaze {
  
}
