//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String a, String b, int x, int y){
        // code here
        int sto[][] = new int[x][y];
		int ans = 0;
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				if(a.charAt(i)==b.charAt(j))
					sto[i][j] = 1 + ((i==0 || j==0)?0:sto[i-1][j-1]);
				else
					sto[i][j] = 0;
				ans = Math.max(sto[i][j],ans);
			}
		}
		return ans;
    }
}