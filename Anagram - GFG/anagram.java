//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    
		    if(obj.isAnagram(s1,s2))
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		         System.out.println("NO");
		    }
		    
		    
		    
		}
	}
}
// } Driver Code Ends


class Solution
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String c1,String c2)
    {
        
        // Your code here
        if(c1.length()!=c2.length())return false;
	   Map<Character,Integer> hm1 = new HashMap<>();
	   Map<Character,Integer> hm2 = new HashMap<>();
	   for(int i=0;i<c1.length();i++){
		   char t = c1.charAt(i);
		   if(hm1.containsKey(t))
			   hm1.put(t,hm1.get(t)+1);
		   else
			   hm1.put(t,1);
	   }
	   for(int i=0;i<c2.length();i++){
		   char t = c2.charAt(i);
		   if(hm2.containsKey(t))
			   hm2.put(t,hm2.get(t)+1);
		   else
			   hm2.put(t,1);
	   }
	   if(hm1.size()!=hm2.size())return false;
	   for(char c:hm1.keySet()){
	       int t1 = hm2.getOrDefault(c,0);
	       int t2 = hm1.getOrDefault(c,0);
		   if(!hm2.containsKey(c))return false;
		   else if(t1!=t2)return false;
	   }
	   return true;
        
    }
}