//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int a[], int N, int k) {
        // code here.
        Long dp[][] = new Long[N][k+1];
        return memo(0,k,a,dp);
    }
    
    private long memo(int i,int k,int a[],Long dp[][]){
        if(k==0)return 1;
        if(i==a.length || k<0)return 0;
        if(dp[i][k]!=null)return dp[i][k];
        long yes = memo(i,k-a[i],a,dp);
        long no = memo(i+1,k,a,dp);
        
        return dp[i][k] = yes + no;
    }
}