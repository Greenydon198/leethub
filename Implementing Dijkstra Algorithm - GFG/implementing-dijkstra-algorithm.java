//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int n, ArrayList<ArrayList<ArrayList<Integer>>> graph, int s)
    {
        // Write your code here
        min = new PriorityQueue<int[]>((a,b)->(a[0]>b[0])?1:-1);
        int ans[] = new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        // System.out.println(graph);
        min.add(new int[]{0,s});
        bfs(graph,ans);
        
        return ans;
    }
    
	static PriorityQueue<int[]> min;
	
	public static void bfs(ArrayList<ArrayList<ArrayList<Integer>>> graph,int ans[]){
		while(min.size()>0){
			int wt = min.peek()[0];
			int s = min.remove()[1];
			if(wt<ans[s]){
				ans[s] = wt;
			}
			for(ArrayList<Integer> i:graph.get(s)){
				int tempwt = i.get(1) + wt;
				int nbr = i.get(0);
				if(tempwt<ans[nbr])
					min.add(new int[]{tempwt,nbr});
			}
		}
	}
}

