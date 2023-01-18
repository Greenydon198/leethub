//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int s = Integer.parseInt(S[2]);
            int d = Integer.parseInt(S[3]);
            int[][] edges = new int[m][2];
            for(int i = 0; i < m; i++){
                String[] S1 = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(S1[0]);
                edges[i][1] = Integer.parseInt(S1[1]);
            }
            Solution obj = new Solution();
            int ans = obj.possible_paths(edges, n, s, d);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int possible_paths(int[][] edge, int n, int s, int d)
    {
        // Code here  
        if(s==d)return 1;
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++)
            graph[i] = new ArrayList<>();
        
        for(int i[]:edge)
            graph[i[0]].add(i[1]);
            
        boolean visit[] = new boolean[n];
        int ans[] = new int[1];
	   dfs(s,d,graph,visit,ans);
	   return ans[0];
   }
	private void dfs(int s, int d,ArrayList<Integer> graph[],boolean visit[],int[] ans){

		visit[s] = true;
		for(int i=0;i<graph[s].size();i++){
			int tmp = graph[s].get(i);
			if(tmp==d){
				ans[0]++;
				continue;
			}
			if(!visit[tmp])
				dfs(tmp,d,graph,visit,ans);
		}
		visit[s]=false;
	}
}