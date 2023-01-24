//{ Driver Code Starts
// Initial Template for Java

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
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] a) {

        // Your code here
        int n = a.length;
	  int m = a[0].length;
	  Queue<int[]> q = new LinkedList<>();
	  for(int i=0;i<m;i++){
		  if(a[0][i]==1){
			 q.add(new int[]{0,i});
			  a[0][i]= 0;
		  }
		  if(a[n-1][i]==1)
			  q.add(new int[]{n-1,i});
		  a[n-1][i]=0;
	  }
	   for(int i=0;i<n;i++){
		  if(a[i][0]==1){
			 q.add(new int[]{i,0});
			  a[i][0]=0;
			  }
		  if(a[i][m-1]==1){
			  q.add(new int[]{i,m-1});
			  a[i][m-1]=0;
		  }
	  }
	  int di[] = {0,1,0,-1};
	  int dj[] = {1,0,-1,0};
	  while(q.size()>0){
		  // System.out.println(q.peek()[0]+" "+q.remove()[1]);
		  int i = q.peek()[0];
		  int j = q.remove()[1];
		  for(int x = 0;x<4;x++){
			  int ni = i+di[x];
			  int nj = j+dj[x];
			  if(ni<0 || nj<0 || ni>=n || nj>=m)continue;
			  if(a[ni][nj]==1){
				  q.add(new int[]{ni,nj});
				  a[ni][nj] = 0;
			  }
		  }
	  }
	  int cnt = 0;
	  for(int i[]:a){
		  for(int j:i){
			  if(j==1)cnt++;
		  }
	  }
	  return cnt;
    }
}