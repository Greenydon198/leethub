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
        int freq[] = new int[256];//store distinct elements
        int dist = 0;//cnt the no.of unique elements
        int n = s.length();
        for(int i=0;i<n;i++){
            char temp = s.charAt(i);
            freq[temp]++;
            if(freq[temp]==1)dist++;
        }
        
        int st = 0;
        int en =0;
        int ans = Integer.MAX_VALUE;//to get min len of all unique elements
        
        HashMap<Character,Integer> hm = new HashMap<>();//to store variables and their cnt
        
        while(en<n){
            char temp = s.charAt(en);
            hm.put(temp,hm.getOrDefault(temp,0)+1);
            if(hm.get(temp)==1)dist--;
            en++;
            
            while(dist<=0){
                ans = Math.min(en-st,ans);//updates ans everytime length is minimum
                
                char start = s.charAt(st);
                hm.put(start,hm.get(start)-1);
                
                if(hm.get(start)==0)
                    dist++;
                st++;
            }
        }
        return ans;
    }
}






