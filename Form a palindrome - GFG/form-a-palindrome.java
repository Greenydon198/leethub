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
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int findMinInsertions(String a){
        // code here
        char s[] = a.toCharArray();
       return mismatch(0,s.length-1,s,new Integer[s.length][s.length]);
  }

	private int mismatch(int i,int j,char[] s,Integer sto[][]){
		if(i>=j)return 0;

		if(sto[i][j]!=null)return sto[i][j];
		
		int res = 0;
		if(s[i]==s[j])
			res = mismatch(i+1,j-1,s,sto);
		else{
			int i_inc = 1 + mismatch(i+1,j,s,sto);
			int j_dec = 1 + mismatch(i,j-1,s,sto);
			int both = 2 + mismatch(i+1,j-1,s,sto);
			res = Math.min(i_inc,Math.min(j_dec,both));
		}
		sto[i][j] = res;
		return res;
    }
}