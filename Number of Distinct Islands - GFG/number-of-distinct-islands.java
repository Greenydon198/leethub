//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] a) {
        // Your Code here
        int n = a.length;
	    int m = a[0].length;
	    boolean visit[][] = new boolean[n][m];
	    HashSet<ArrayList<String>> hm = new HashSet<>();
	    for(int i=0;i<n;i++){
		  for(int j=0;j<m;j++){
			  if(!visit[i][j] && a[i][j]==1){
				  ArrayList<String> al = new ArrayList<>();
				  bfs(i,j,a,visit,al);
				  hm.add(al);
			  }
		  }
	    }
	  // System.out.println(hm);
	  return hm.size();
    }

	static int dimx[] = {1,0,-1,0};
	static int dimy[] = {0,1,0,-1};
	
	private static void bfs(int i,int j,int a[][],boolean visit[][],ArrayList<String> al){
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{i,j});
		visit[i][j] = true;
		int n = a.length;
		int m = a[0].length;
		int mi = i;
		int mj = j;
		// int cnt = 1;
		while(q.size()>0){
			i = q.peek()[0];
			j = q.remove()[1];
			al.add(i-mi+""+(j-mj));
			for(int x=0;x<4;x++){
				int ni = i+dimx[x];
				int nj = j+dimy[x];
				if(ni<0 || ni>=n || nj<0 || nj>=m)continue;
				else if(!visit[ni][nj] && a[ni][nj]==1){
					q.add(new int[]{ni,nj});
					visit[ni][nj] = true;
				}
			}
		}
    }
}
