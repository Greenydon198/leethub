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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.largestPrimeFactor(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long largestPrimeFactor(int n) {
        // code here
        long ans = -1,mn = n;
        if(n==1)System.out.print(1+" ");
		while(n>1){	
			for(int i=2;i<=n;i++){
				if(n%i==0){
					ans = Math.max(i,ans);
					n/=i;
					break;
				}
			}
		} 
		if(ans==-1)return mn;
		return ans;
    }
}