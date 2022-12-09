//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends

// import java.util.Stack;

class Solution {
    // Function to convert an infix expression to a postfix expression.
    int pres(char c){
        if(c=='^')return 3;
		if(c=='*' || c =='/')return 2;
		else if(c=='+'|| c=='-')return 1;
		return 0;
	}
    public String infixToPostfix(String s) {
        // Your code here
        int n = s.length(); 
        String res = "";
		Stack <Character> st = new Stack<>();
		for(int i=0;i<n;i++){
			char t = s.charAt(i);
			if(Character.isLetterOrDigit(t))res = res+t;
			else if(t=='(')st.push(t);
			else if(t==')'){
				while(!st.empty() && st.peek()!='('){
					res =res +st.pop();
				}st.pop();
			}
			else{
				while(!st.empty() && pres(t)<=pres(st.peek()))
					res =res +st.pop();
				st.push(t);
			}
			// System.out.println(st+" "+res);
		}
		while(!st.empty())
			res = res+st.pop();
		return res;
    }
}