//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minCoins(int a[], int M, int k) 
	{ 
	    // Your code goes here
	    Integer dp[][] = new Integer[a.length][k+1];
        int ans = memo(0,k,a,dp);
        if(ans==Integer.MAX_VALUE)return -1;
        return ans;
    }
    
    private int memo(int i,int k,int a[],Integer dp[][]){
        if(k==0)return 0;
        if(i==a.length || k<0)return Integer.MAX_VALUE;

        if(dp[i][k]!=null)return dp[i][k];
        int yes = memo(i,k-a[i],a,dp);
        int no = memo(i+1,k,a,dp);
        if(yes/10+1<=Integer.MAX_VALUE/10)yes++;
        return dp[i][k] = Math.min(yes,no);
	} 
}