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
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.printMinNumberForPattern(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
     String printMinNumberForPattern(String s){
        // code here
        String ans = "";
		Stack <Character> no = new Stack<>();
		Stack <Character> st = new Stack<>();
		for(int i=1;i<=s.length()+1;i++)
			no.push((char)(i+'0'));
			// System.out.println(st+"\n"+no);
		for(int i=s.length()-1;i>=0;i--){
			char t = s.charAt(i);
			if(t=='I'){
				String temp="";
				while(!st.empty()){
					temp = temp+no.pop();
					st.pop();
				}
				ans = temp+no.pop()+ans;
			}
			else
				st.push(t);
			// System.out.println(st+"\n"+no);
		}
		String a ="";
		while(!st.empty()){
			a =a+no.pop();
			st.pop();
		}
		return a+no.pop()+ans;
    }
}
