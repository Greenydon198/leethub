//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String s) {
        // Your code goes here
        int n = s.length();
        int count = charcount(s,n);
        int ans = n+1;
         HashMap<Character,Integer> hm = new HashMap<>();
        //  System.out.println(count);
        for(int i=0,j=0;i<n;i++){
            char temp = s.charAt(i);
            hm.put(temp,hm.getOrDefault(temp,0)+1);
            while(hm.size()==count){
                char t = s.charAt(j);
                ans = Math.min(ans,i-j+1);
                if(hm.get(t)==1)hm.remove(t);
                else
                    hm.put(t,hm.get(t)-1);
                j++;
            }
        }
        return ans;
    }
    int charcount(String s,int n){
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(s.charAt(i),1);
        }
        return hm.size();
    }
}