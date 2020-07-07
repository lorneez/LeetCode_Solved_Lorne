package CTCI_Trees_And_Graphs.Leetcode;

import java.util.ArrayList;
import java.util.List;
// good problem about adjacency lists and inlink arrays.
class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n < 2){
            ArrayList<Integer> ret = new ArrayList<>();
            ret.add(0);
            return ret;
        }
        int[] in = new int[n];
        List<List<Integer>> adj = getAdjacencyLists(n, edges, in);

        List<Integer> leaves = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(in[i] == 1){
                leaves.add(i);
            }
        }


        while(n > 2){
            List<Integer> newLeaves = new ArrayList<>();
            for(int leaf : leaves) {
                for(int nb : adj.get(leaf)){
                    in[nb] --;
                    if(in[nb] == 1){
                        newLeaves.add(nb);
                    }
                }
            }
            n -= leaves.size();
            leaves = newLeaves;
        }
        return leaves;
    }

    public List<List<Integer>> getAdjacencyLists(int n, int [][] edges, int[] in) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] x : edges){
            List<Integer> l = new ArrayList<>();
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
            in[x[0]] ++;
            in[x[1]] ++;
        }
        return adj;
    }
}
