//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String s)
    {
        // add your code here
        int n = s.length();
		Stack <Character> st = new Stack<>();
		for(int i=0;i<n;i++){
			char t = s.charAt(i);
			if("([{".indexOf(t)!=-1)
				st.push(t);
			else if(t==')' && st.size()>0 && st.peek()=='(')
				st.pop();
			else if(t==']' &&  st.size()>0 && st.peek()=='[')
				st.pop();
			else if(t=='}' && st.size()>0 && st.peek()=='{')
				st.pop();
			else if(")]}".indexOf(t)!=-1)
				return false;
			// System.out.println(st);
		}
		if(st.size()>0)
			return false;
		else 
			return true;
    }
}
