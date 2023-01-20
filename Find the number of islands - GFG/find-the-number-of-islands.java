//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] a) {
        // Code here
        int n = a.length;
        int m = a[0].length;
        boolean visit[][] = new boolean[n][m];
		int cnt = 0;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(!visit[i][j] && a[i][j]=='1'){
					bfs(i,j,a,visit);
					// System.out.println(temp); 
                    cnt++;
				}
			}
		}
		return cnt;
    }

	static int dimx[] = {1,0,-1,0,-1,1,-1,1};
	static int dimy[] = {0,1,0,-1,-1,1,1,-1};
	
	private static void bfs(int i,int j,char a[][],boolean visit[][]){
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{i,j});
		visit[i][j] = true;
		int n = a.length;
		int m = a[0].length;
		while(q.size()>0){
			i = q.peek()[0];
			j = q.remove()[1];
			for(int x=0;x<8;x++){
				int ni = i+dimx[x];
				int nj = j+dimy[x];
				if(ni<0 || ni>=n || nj<0 || nj>=m)continue;
				else if(!visit[ni][nj] && a[ni][nj]=='1'){
					q.add(new int[]{ni,nj});
					visit[ni][nj] = true;
				}
			}
		}
    }
}