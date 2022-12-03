class Solution {
    public boolean isValid(String s) {
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