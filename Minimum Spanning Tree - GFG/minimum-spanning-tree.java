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
	    Arrays.sort(edges,(x,y)->x[2]-y[2]);
	    
	    par = new int[n];
	    size = new int[n];
	    
	    for(int i=0;i<n;i++){
	        par[i] = i;
	    }
	    
	    int ans = 0;
	    for(int i[]:edges){
	        int s = i[0];
	        int d = i[1];
	        int w = i[2];
	        
	        int rs = findroot(s);
	        int rd = findroot(d);
	        
	        if(rs==rd)continue;
	        
	        if(size[rd]<size[rs]){
	            int t = rs;
	            rs = rd;
	            rd = t;
	        }
	        
	        union(rs,rd);
	        
	        ans += w;
	    }
	    
	    return ans;
	}
	
	static int par[];
    static int size[];
    
    static int findroot(int r){
        if(par[r]==r)return r;
        
        return par[r] = findroot(par[r]);
    }
    
    static void union(int rs,int rd){
        par[rd] = rs;
        size[rs] += size[rd];
    }
    
}