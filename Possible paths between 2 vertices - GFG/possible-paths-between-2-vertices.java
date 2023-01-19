//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            String[] S1 = br.readLine().trim().split(" ");
            int source = Integer.parseInt(S1[0]);
            int destination = Integer.parseInt(S1[1]);
            Solution obj = new Solution();
            System.out.println(obj.countPaths(V, adj, source, destination));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to count paths between two vertices in a directed graph.
    public int countPaths(int n, ArrayList<ArrayList<Integer>> graph, int u,int v) {
        // Code here
        boolean visit[] = new boolean[n];
        return dfs(u,v,graph,visit);
    }
    
    private int dfs(int u,int v,ArrayList<ArrayList<Integer>> graph,boolean visit[]){
        if(u==v){
            return 1;
        }

        int ans = 0;
        visit[u] = true;
        for(int i:graph.get(u)){
            if(!visit[i]){
                ans += dfs(i,v,graph,visit);
            }
        }
        
        visit[u] = false;
        return ans;
    }
}