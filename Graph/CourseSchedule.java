import java.util.*;

public class CourseSchedule {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
    
    for (int[] p : prerequisites) {
        adj.get(p[1]).add(p[0]);  // edge: p[1] -> p[0] 
    }
    
    int[] state = new int[numCourses];  // 0 = unvisited, 1 = visiting, 2 = done
    
    for (int i = 0; i < numCourses; i++) {
        if (state[i] == 0) {
            if (hasCycle(i, adj, state)) return false;
        }
    }
    return true;
  }
    
  boolean hasCycle(int node, List<List<Integer>> adj, int[] state) {
      state[node] = 1; // visiting
      
      for (int nei : adj.get(node)) {
          if (state[nei] == 1) return true;  // back edge → cycle
          if (state[nei] == 0 && hasCycle(nei, adj, state)) return true;
      }
      
      state[node] = 2; // done
      return false;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    sc.close();
  }
}
