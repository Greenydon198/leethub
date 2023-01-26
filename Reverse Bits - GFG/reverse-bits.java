//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG
{
	static int n;
	static int k;
	
	// Driver Code
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); //Inputting the testcases
		
		while(t>0) //While testcases exist
		{
			
			n = Integer.parseInt(br.readLine()); //Input N
			
			Solution obj = new Solution();
			
			System.out.println(obj.reverseBits(n));
            
            t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int reverseBits(int n)
    {
        //code here
        int ans = 0;
        int pos = -1;
		for(int i=31;i>=0;i--){
			if((n&(1<<i))!=0){
			    pos = i;
			    break;
			}
		}
// 		System.out.println(pos);
		for(int i=pos;i>=0;i--){
			if((n&(1<<i))!=0)ans+=(1<<(pos-i));
		}
		return ans;
    }
}