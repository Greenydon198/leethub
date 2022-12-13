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
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// class Solution
// {
//     //Function to find minimum time required to rot all oranges. 
//     public int orangesRotting(int[][] grid)
//     {
//         // Code here
//     }
// }
class pair{
	int f;
	int l;
	pair(int f,int l){
		this.f = f;
		this.l = l;
	}
}
class Solution{        
	 public int orangesRotting(int[][] a) {
//your code
		 int n = a.length,m=a[0].length,c=0;
		 Stack<pair> st = new Stack<>();
		 for(int i=0;i<n;i++)
			 for(int j =0;j<m;j++)
				 if(a[i][j]==2)st.push(new pair(i,j));
		 // System.out.println(st+" "+st.peek().f+" "+st.peek().l);
		 while(!st.empty()){
			 Stack<pair> temp = new Stack<>();
			 while(!st.empty()){
				 pair t = st.pop();
				 if(t.f+1<n && a[t.f+1][t.l]==1){
					 a[t.f+1][t.l]=2;
					 temp.push(new pair(t.f+1,t.l));
				 }
				 if(t.l+1<m && a[t.f][t.l+1]==1){
					 a[t.f][t.l+1]=2;
					 temp.push(new pair(t.f,t.l+1));
				 }
				 if(t.l-1>=0 && a[t.f][t.l-1]==1){
					 a[t.f][t.l-1]=2;
					 temp.push(new pair(t.f,t.l-1));
				 }
				 if(t.f-1>=0 && a[t.f-1][t.l]==1){
					 a[t.f-1][t.l]=2;
					 temp.push(new pair(t.f-1,t.l));
				 }
			 }
			 if(temp.size()>0)
			 c++;
			 while(temp.size()>0){
				 st.push(temp.pop());
				 
			 }
		 }
		 boolean f =false;
		 for(int i=0;i<n;i++){
			 for(int j=0;j<m;j++){
				 if(a[i][j]==1)return -1;
				 if(a[i][j]==2)f=true;
			 }
			 // System.out.println(Arrays.toString(a[i]));
		 }
		 // if(f)return -1;
		 return c;
	}
}