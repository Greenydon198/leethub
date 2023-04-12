//{ Driver Code Starts
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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] a)
    {
        // Code here
        Queue<int[]> q = new LinkedList<>();
		int n = a.length;
		int m = a[0].length;
		int x[] = {1,0,-1,0};
		int y[] = {0,1,0,-1};
		boolean visit[][] = new boolean[n][m];
		for(int i=0;i<n;i++)
			for(int j =0 ;j<m;j++)
				if(a[i][j]==1){
					q.add(new int[]{i,j});
					visit[i][j] = true;
				}
		
		int level = 0;
		while(q.size()>0){
			int len = q.size();
			while(len-->0){
				int i = q.peek()[0];
				int j = q.remove()[1];
				a[i][j] = level;
				for(int k=0;k<4;k++){
					int ni = i+x[k];
					int nj = j+y[k];
					if(ni<0 || ni>=n || nj<0 || nj>=m)continue;
					else if(a[ni][nj]==0 && !visit[ni][nj]){
						visit[ni][nj] = true;
						q.add(new int[]{ni,nj});
					}
				}
			}
			level++;
		}
		return a;
    }
}