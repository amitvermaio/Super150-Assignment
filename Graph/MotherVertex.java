package Graph;

import java.util.ArrayList;

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
