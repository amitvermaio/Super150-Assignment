import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule2 {
  public int[] findOrder(int n, int[][] pre) {
    int[] indeg = new int[n];
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
    for (int[] e : pre) {
        adj.get(e[1]).add(e[0]);
        indeg[e[0]]++;
    }

    int[] res = new int[n];
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < n; i++) if (indeg[i] == 0) q.add(i);

    int k = 0;
    while (!q.isEmpty()) {
        int node = q.poll();
        res[k++] = node;
        for (int nei : adj.get(node)) {
            indeg[nei]--;
            if (indeg[nei] == 0) q.add(nei);
        }
    }

    return (k == n) ? res : new int[0];
  }

  public static void main(String[] args) {
    
  }
}
