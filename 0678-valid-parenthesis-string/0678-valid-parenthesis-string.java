class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
		Stack<Integer> star = new Stack<>();
        for(int i=0;i<n;i++){
			char t = s.charAt(i);
			if(t=='(')st.push(i);
			else if(t=='*')star.push(i);
			else if(!st.empty())st.pop();
			else if(!star.empty())star.pop();
			else 
				return false;
			// System.out.println(st+"    "+star);
		}
        while(!st.isEmpty() && !star.isEmpty() && st.peek() < star.peek()){
            st.pop();
            star.pop();
        }
        
        return st.isEmpty();
    }
}