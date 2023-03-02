//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int n, int a[])
    {
        // code here
        // return memo(0,n-1,a,new Integer[a.length][a.length]);
        
        //tabulation
        int dp[][] = new int[n][n];
        
        for(int d=0;d<n;d++){//d=diag
            for(int s=0,e=d+1;e<n;s++,e++){
                if(s+1==e)continue;
            
                int min = Integer.MAX_VALUE;
                
                for(int i=s+1;i<e;i++){
                    int cut1 = dp[s][i];//memo(s,i,a,dp);
                    int cut2 = dp[i][e];//memo(i,e,a,dp);
                    int res = a[s]*a[i]*a[e] + cut1 + cut2;
                    
                    min = Math.min(min,res);
                }
            
                dp[s][e] = min;
                // System.out.println(Arrays.toString(dp[s]));
            }
        }
        return dp[0][n-1];
    }
    
    private static int memo(int s,int e,int a[],Integer dp[][]){
        
        if(s+1==e)return 0;
        
        if(dp[s][e]!=null)return dp[s][e];
        
        int min = Integer.MAX_VALUE;
        
        for(int i=s+1;i<e;i++){
            int cut1 = memo(s,i,a,dp);
            int cut2 = memo(i,e,a,dp);
            int res = a[s]*a[i]*a[e] + cut1 + cut2;
            
            min = Math.min(min,res);
        }
        
        return dp[s][e] = min;
    }
}