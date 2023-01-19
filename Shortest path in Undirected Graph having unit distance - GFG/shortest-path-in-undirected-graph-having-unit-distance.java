//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++)
            graph[i] = new ArrayList<>();
        
        for(int i[] : edges){
            graph[i[0]].add(i[1]);
            graph[i[1]].add(i[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        int ans[] = new int[n];
        ans[src] = 0;
        boolean visit[] = new boolean[n];
        int ind = 1;
        visit[src] = true;
        while(q.size()>0){
            int len = q.size();
            while(len-->0){
                int temp = q.remove();
                for(int i:graph[temp])
                    if(!visit[i]){
                        q.add(i);
                        ans[i] = ind;
                        visit[i] = true;
                    }
            }
            ind++;
        }
        for(int i=0;i<n;i++)
            if(ans[i]==0 && i!=src)
                ans[i] = -1;
        
        return ans;
    }
}