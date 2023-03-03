//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to return the total number of possible unique BST.
    static int numTrees(int n)
    {
        // Your code goes here
        //catalan approach
        int m = (int)(1e9)+7;
		long dp[] = new long[n+1];
		dp[0] = dp[1] = 1;
		for(int c=2;c<=n;c++){
			for(int i=0,j=c-1;i<=c-1;i++,j--){
				dp[c] = (dp[c]+(dp[i]%m*dp[j]%m)%m)%m;
			}
		}

		return (int)(dp[n]%m);
        
    }
}


//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])
    {
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking n
            int n =sc.nextInt();
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling method numTrees() of 
            //class Solution
            System.out.println(ob.numTrees(n));
        }
    }
}

// } Driver Code Ends