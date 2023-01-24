//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int n,int m, int[][] a) {
		//Code here
		ArrayList<pair> graph[] = new ArrayList[n];
		for(int i = 0;i<n;i++)
		    graph[i] = new ArrayList<>();
		
		for(int i[]:a){
		    graph[i[0]].add(new pair(i[1],i[2]));
		}
	
		int ans[] = new int[n];
		Arrays.fill(ans,Integer.MAX_VALUE);
		
		dfs(0,graph,ans,0);
		for(int i=1;i<n;i++)
		    if(ans[i]==Integer.MAX_VALUE)ans[i] = -1;
		return ans;
	}
	
	private void dfs(int s,ArrayList<pair> graph[],int ans[],int wt){
	    if(ans[s]>wt){
	        ans[s] = wt;
	    }
	    for(pair i:graph[s]){
	        if(wt+i.w<ans[i.nbr]){
	            dfs(i.nbr,graph,ans,wt+i.w);
	        }
	    }
	}
	class pair{
    int nbr;
    int w;
    pair(int nb,int wt){
        nbr = nb;
        w = wt;
    }
}
}

