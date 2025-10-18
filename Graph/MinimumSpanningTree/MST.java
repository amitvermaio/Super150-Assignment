package super150.Graph.MinimumSpanningTree;

import java.util.Arrays;

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

public class MST {
  // Minimum Spanning Tree (MST) using Kruskal's Algorithm and Prims Algorithm
  // Kruskal's Algorithm uses Disjoint Set Union (DSU) data structure
  // Kruskal's Algorithm is a greedy algorithm that finds the minimum spanning tree for a connected weighted graph
  // It finds a subset of the edges that forms a tree that includes every vertex, where the total weight of all the edges in the tree is minimized
  // Steps:
  // 1. Sort all the edges in non-decreasing order of their weight
  // 2. Pick the smallest edge. Check if it forms a cycle with the spanning tree formed so far. If cycle is not formed, include this edge. Else, discard it.
  // 3. Repeat step 2 until there are (V-1) edges in the spanning tree where V is the number of vertices
  // T(O) of MST -> O(E log E) where E is the number of edges
  // S(O) of MST -> O(V + E) where V is the number of vertices

  // PROBLEM TYPES -> Connect all with minimum cost!!!

  public static void main(String[] args) {
    int edges = {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}};
    int V = 4;
    UnionFind uf = new UnionFind(V);
    Arrays.sort(edges, (a, b) -> a[2] - b[2]);
    int sum = 0;
    int edgeCount = 0;
    for (int[] edge : edges) {
        if (uf.union(edge[0], edge[1])) {
            sum += edge[2];
            edgeCount++;
        }
        if (edgeCount == V-1) break; // coz WE NEED AT MOST V(NUMBER OF VERTICES)-1 EDGES TO CONNECT ALL THE VERTICES!
    }
    System.out.println(sum);
  }
  
}
