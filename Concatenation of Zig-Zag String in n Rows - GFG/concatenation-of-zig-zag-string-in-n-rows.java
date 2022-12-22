//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    int n=sc.nextInt();
                    Solution obj = new Solution();
                    System.out.println(obj.convert(s,n));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String convert(String s, int k)
    {
        //code here
        if(k==1)return s;
		Map<Integer,StringBuilder> hm = new TreeMap<>();
		int n = s.length();
		boolean down = true;
		boolean up = false;
		for(int i =0,j=1;i<n;i++){
			if(j>k){
				down = false;
				up=true;
				j-=2;
			}
			else if(j==0){
				down=true;
				up=false;
				j=2;
			}
			StringBuilder al = hm.getOrDefault(j,new StringBuilder());
			al.append(s.charAt(i));
			hm.put(j,al);
			// System.out.println(hm+" "+al);
			if(down)j++;
			if(up)j--;
		}
		StringBuilder ans = new StringBuilder();
		for(StringBuilder i:hm.values()){
			ans.append(i);
		}
		return ans.toString();
        
    }
}