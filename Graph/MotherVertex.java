package Graph;

import java.util.ArrayList;

// Iss  Problems ka concept simple hai agar jis node se hum saare node ko visit kar sakte hai wo mother vertex hoga
// To hum pehle ek dfs lagayenge aur jaha se last me dfs complete hoga wo candidate hoga
// Fir us candidate se fir se dfs lagayenge aur check karenge ki kya hum sare node ko visit kar pa rahe hai
// Agar haan to wo mother vertex hoga nahi to -1 return kar denge

public class MotherVertex {
  static int total;
        
  static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int src) {
      visited[src] = true;
      total++;
      for (int nei : adj.get(src)) {
          if (!visited[nei]) {
              dfs(adj, visited, nei);
          }
      }
  }
  
  public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
      int candidate = -1;
      boolean[] visited = new boolean[V];
      
      // Find candidate
      for (int i = 0; i < V; i++) {
          if (!visited[i]) {
              dfs(adj, visited, i);
              candidate = i;
          }
      }
      
      // Verify candidate
      visited = new boolean[V];
      total = 0;
      dfs(adj, visited, candidate);
      
      return (total == V) ? candidate : -1;
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i=0; i<5; i++) adj.add(new ArrayList<>());
    adj.get(0).add(2);
    adj.get(0).add(3);
    adj.get(1).add(0);
    adj.get(2).add(1);
    adj.get(3).add(4);
  
    MotherVertex obj = new MotherVertex();
    int res = obj.findMotherVertex(adj.size(), adj);
    System.out.println(res);
  }
}

/* Stack Method -> More Understandable but same logic

class Solution {
    static int count;

    // Simple DFS to count reachable vertices
    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int src) {
        if (visited[src]) return;
        visited[src] = true;
        count++;
        for (int nbr : adj.get(src)) {
            dfs(adj, visited, nbr);
        }
    }

    // DFS with stack for ordering
    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st, int src) {
        if (visited[src]) return;
        visited[src] = true;
        for (int nei : adj.get(src)) {
            dfs(adj, visited, st, nei);
        }
        st.add(src);
    }

    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];

        // Step 1: Do DFS for all vertices and store finish order in stack
        for (int i = 0; i < V; i++) {
            dfs(adj, visited, st, i);
        }

        // Step 2: Get last finished vertex (potential mother vertex)
        int res = st.pop();

        // Step 3: Check if this vertex can reach all nodes
        visited = new boolean[V];
        count = 0;
        dfs(adj, visited, res);

        return count == V ? res : -1;
    }
}
*/