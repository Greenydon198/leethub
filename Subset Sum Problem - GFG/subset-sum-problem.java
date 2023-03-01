//{ Driver Code Starts
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
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int a[], int k){
        // code here
        // return memo(0,a,k,new Boolean[a.length][k+1]);
        
        //tabulation
        boolean dp[][] = new boolean[a.length+1][k+1];
        for(int i=0;i<=a.length;i++)
            dp[i][0] = true;
            
        for(int i=a.length-1;i>=0;i--){
            for(int j=1;j<=k;j++){
                if(j-a[i]>=0 && j-a[i]<=k)
                dp[i][j] = dp[i+1][j-a[i]];
                dp[i][j] = dp[i][j] || dp[i+1][j];
            }
            // System.out.println(Arrays.toString(dp[i]));
        }
        return dp[0][k];
    }
    
    private static boolean memo(int i,int a[],int k,Boolean dp[][]){
        if(k==0)return true;
        if(i==a.length || k<0)return false;
        if(dp[i][k]!=null)return dp[i][k];
        boolean yes = memo(i+1,a,k-a[i],dp);
        boolean no = memo(i+1,a,k,dp);
        
        return dp[i][k] = yes || no;
    }
}