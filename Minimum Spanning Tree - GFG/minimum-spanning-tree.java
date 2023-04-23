//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
	static int spanningTree(int n, int E, int edge[][]){
	    // Code Here. 
	    
	    int graph[][] = adj_matrix(edge,n);
	    
	    int key[] = new int[n];
	    int par[] = new int[n];
	    boolean vis[] = new boolean[n];
	    
	    key[0] = 0;
	    par[0] = -1;
	    
	    for(int i=1;i<n;i++){
	        key[i] = Integer.MAX_VALUE;
	    }
	    
	    for(int k=0;k<n;k++){
	        
	        int ind = min_ind(key,vis);
	        
	        vis[ind] = true;
	        
	        for(int i=0;i<n;i++){
	            if(graph[ind][i]!=0 && !vis[i] && graph[ind][i]<key[i]){
	                key[i] = graph[ind][i];
	                par[i] = ind;
	            }
	        }
	    }
	    
	    int ans = 0;
	    for(int i:key){
	        ans += i;
	    }
	    
	    return ans;
	}
	
	static int min_ind(int key[],boolean vis[]){
	    
	    int min_ind = -1;
	    for(int i=0;i<key.length;i++){
	        if(!vis[i]){
	            if(min_ind==-1 || (key[min_ind]>key[i]))
	                min_ind = i;
	        }
	    }
	    
	    return min_ind;
	}
	
	static int[][] adj_matrix(int edge[][],int n){
	    
	    int graph[][] = new int[n][n];
	    
	    for(int i[]:edge){
	        graph[i[0]][i[1]] = i[2];
	        graph[i[1]][i[0]] = i[2];
	    }
	    
	    return graph;
	}
}