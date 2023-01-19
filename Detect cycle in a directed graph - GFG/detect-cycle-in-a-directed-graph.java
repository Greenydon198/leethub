//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean mainvisit[] = new boolean[n];
        for(int i=0;i<n;i++){
		    if(!mainvisit[i]){
		        boolean visit[] = new boolean[n];
		        if(dfs(i,adj,visit,mainvisit))return true;
		    
		    }
	    }
	return false;
   }
	private boolean dfs(int s,ArrayList<ArrayList<Integer>>  adj,boolean visit[],boolean mainvisit[]){
	    mainvisit[s] = true;
		visit[s] = true;
		boolean res = false;
		for(int i:adj.get(s)){
			if(visit[i])
				res = true;
			else{
				if(!res && !mainvisit[i])
					res = dfs(i,adj,visit,mainvisit);
			}
		}
		visit[s] = false;
		return res;
    }
}