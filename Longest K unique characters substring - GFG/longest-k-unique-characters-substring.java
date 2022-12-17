//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
		Map<Character,Integer> hm = new HashMap<>();
		int st = 0, e=0,maxlen = -1,n=s.length();
		while(e<n){
			char t = s.charAt(e);
			hm.put(t,hm.getOrDefault(t,0)+1);
			while(hm.size()>k){
				char temp = s.charAt(st);
				int t1 = hm.get(temp);
				if(t1==1)hm.remove(temp);
				else
					hm.put(temp,t1-1);
				st++;
			}
			e++;
			if(hm.size()==k)
			    maxlen = Math.max(maxlen,(e-st));
		}
		return maxlen;
    }
}