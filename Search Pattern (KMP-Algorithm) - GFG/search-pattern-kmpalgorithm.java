//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pat, String a)
    {
        // your code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
		int lps[] = lps(pat);
		// System.out.println(Arrays.toString(lps));
		int i = 0,j = 0;
		int n = a.length();
		int m = pat.length();
		while(i<n){
			if(a.charAt(i)==pat.charAt(j)){
				i++;
				j++;
			}
			else{
				if(j!=0)
					j = lps[j-1];
				else
					i++;
			}
			if(j==m){
				ans.add(i-m+1);
				j = lps[j-1];
			}
		}
		if(ans.size()==0)ans.add(-1);
		return ans;
	}
	private int[] lps(String pat){
		int n = pat.length();
		int lps[] = new int[n];
		lps[0] = 0;
		for(int i=1,j=0;i<n;){
			if(pat.charAt(i)==pat.charAt(j)){
				lps[i++] = ++j;
			}
			else{
				if(j==0)lps[i++] = 0;
				else{
					j = lps[j-1];
				}
			}
		}
		return lps;
	}
}