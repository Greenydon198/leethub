//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxGold(int n, int m, int a[][])
    {
        // code here
        int max = 0;
		for(int i=0;i<n;i++)
			max = Math.max(max,memo(i,0,a,new int[n][m]));
		return max;
		
		/*
		tabular approach
        int sto[][] = new int[n][m];
		for(int j=m-1;j>=0;j--){
			for(int i=0;i<n;i++){
				int updiag = (i-1<0 || j+1>=m)?0:sto[i-1][j+1];
				int right = (j+1>=m)?0:sto[i][j+1];
				int downdiag = (i+1>=n || j+1>=m)?0:sto[i+1][j+1];
	
				sto[i][j] = a[i][j] + Math.max(updiag,Math.max(right,downdiag));
			}
		}

		int max = sto[0][0];
		for(int i=0;i<n;i++){
			// System.out.println(Arrays.toString(sto[i]));
			max = Math.max(max,sto[i][0]);
		}
		return max;
		*/
    }
    
    private static int memo(int i,int j,int a[][],int sto[][]){

		if(i>=a.length || i<0 || j>=a[0].length || j<0)return 0;

		if(sto[i][j]!=0)return sto[i][j];
		
		int updiag = memo(i-1,j+1,a,sto);
		int right = memo(i,j+1,a,sto);
		int downdiag = memo(i+1,j+1,a,sto);

		sto[i][j] = a[i][j] + Math.max(updiag,Math.max(right,downdiag));

		return sto[i][j];
	}
}