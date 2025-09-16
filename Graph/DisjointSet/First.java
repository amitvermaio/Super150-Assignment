
package super150.Graph.DisjointSet;

class UnionFind {
  int[] parent;
  int[] rank;
  
  UnionFind(int V) {
    parent = new int[V+1];
    rank = new int[V+1];
    for(int i=0; i<=V; i++) {
      parent[i] = i;
    }
  }

  int find(int node) {
    if (parent[node] == node) {
      return node;
    }

    return find(parent[node]);
  }

  boolean union(int u, int v) {
    int pu = find(u);
    int pv = find(v);

    if (pu == pv) {
      return false;
    } 

    if (rank[pu] > rank[pv]) {
      parent[pv] = pu;
      rank[pu]++;
    } else {
      parent[pu] = pv;
      rank[pv]++;
    }

    return true;
  }
}
// Disjoint Set Union
// T(O) of DSU -> Alpha(N) ~ O(1)
// S(O) of DSU -> O(2N)
// Alpha is inverse Ackermann function 
public class First {

  public static void main(String[] args) {
    
  }
}