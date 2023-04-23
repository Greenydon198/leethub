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
	static int spanningTree(int n, int E, int edges[][]){
	    // Code Here. 
	    
	    ArrayList<int[]> graph[] = new ArrayList[n];
	    for(int i=0;i<n;i++)
	        graph[i] = new ArrayList<>();
	        
	   for(int i[]:edges){
	       graph[i[0]].add(new int[]{i[1],i[2]});
	       graph[i[1]].add(new int[]{i[0],i[2]});
	   }
	   
	   //bfs(graph);
	    return bfs(graph);
	}
	
	static int bfs(ArrayList<int[]> graph[]){
	    
	    PriorityQueue<pair> pq = new PriorityQueue<>();
	    
	    for(int i[]:graph[0]){
	        pq.add(new pair(i[0],i[1]));
	    }
	    
	    int ans = 0;
	    boolean vis[] = new boolean[graph.length];
	    vis[0] = true;
	    
	    while(pq.size()>0){
	        int d = pq.peek().d;
	       // int d = pq.peek().d;
	        int w = pq.remove().w;
	        
	        if(vis[d])continue;
	        vis[d] = true;
	        ans += w;
	        
	        for(int i[]:graph[d]){
	            if(!vis[i[0]])
	                pq.add(new pair(i[0],i[1]));
	        }
	    }
	    
	    return ans;
	}
}

class pair implements Comparable<pair>{
    // int s;
    int d;
    int w;
    
    pair(int dd,int ww){
        // s = ss;
        d = dd;
        w = ww;
    }
    
    public int compareTo(pair c){
        return this.w - c.w;
    }
}




