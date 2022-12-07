//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            out.println(ob.decodedString(s));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String decodedString(String s){
        // code here
         int n = s.length();
		StringBuilder ans = new StringBuilder(); 
		Stack<Character> st = new Stack<>();
		for(int i=0;i<n;i++){
			char t = s.charAt(i);
			if(t==']'){
				StringBuilder ss = new StringBuilder(); 
				while(!st.empty() && st.peek()!='['){
					ss.append(st.pop());
				}
				st.pop();
				int temp = 0,tt=1;
				while(!st.empty() && "0123456789".indexOf(st.peek())!=-1){
					temp=((st.pop()-'0')*tt)+temp;
					tt*=10;
				}
				ss.reverse();
				StringBuilder sss = new StringBuilder(); 
				while(temp-->0)
					sss.append(ss);
				for(int j=0;j<sss.length();j++){
					st.push(sss.charAt(j));
				}
			}
			else
				st.push(t);
		}
		for(;!st.empty();st.pop()){
			ans.append(st.peek());
		}
		return ans.reverse().toString();
    }
}