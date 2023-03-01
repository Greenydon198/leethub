//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int a[], int n){
        // Your code here
        return memo(0,a,new Integer[a.length]);
    }
    
    private int memo(int i,int a[],Integer dp[]){
        if(i>=a.length)return 0;
        if(dp[i]!=null)return dp[i];
        int rob = a[i] + memo(i+2,a,dp);
        int skip = memo(i+1,a,dp);
        
        dp[i] =  Math.max(rob,skip);
        return dp[i];
    }
}