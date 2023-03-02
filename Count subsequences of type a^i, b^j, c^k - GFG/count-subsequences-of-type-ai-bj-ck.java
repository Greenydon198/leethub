//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int t = Integer.parseInt(sc.next());
		
		while(t>0)
		{
		    String s = sc.next();
		    
		    Solution T = new Solution();
		    System.out.println(T.fun(s));
		    
		    t--;
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int fun(String s)
    {
        //write your code here
		long a = 0;
		long b = 0;
		long c = 0;
		long m = 1000000007;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='a')a = (a + a + 1)%m;
			if(s.charAt(i)=='b')b = (a + b + b)%m;
			if(s.charAt(i)=='c')c = (b + c + c)%m;
		}
		return (int)c;
    }
}