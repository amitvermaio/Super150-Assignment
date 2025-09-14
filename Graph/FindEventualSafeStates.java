package Graph;

public class FindEventualSafeStates {
  
}


class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // reverse graph (mean pointing from u->v change to v->u)
        // then apply kahn's Algorithm 
        // It will always work!
        List<List<Integer>> adj = new ArrayList<>();
        int V = graph.length;
        int[] indeg = new int[V];
        for (int i=0; i<V; i++) adj.add(new ArrayList<>());
        for (int i=0; i<V; i++) {
            for (int nei : graph[i]) {
                adj.get(nei).add(i);
                indeg[i]++;
            }
        }

        // Now Kahn's Algo Implement
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<V; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            for (int i : adj.get(node)) {
                indeg[i]--;
                if (indeg[i] == 0) {
                    q.add(i);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
