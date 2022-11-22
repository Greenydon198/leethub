class Solution {
    public String defangIPaddr(String st) {
        char c[] = st.toCharArray();
        String s = "";
        for(int i=0;i<c.length;i++)
            if(c[i]=='.')
                s+="["+c[i]+"]";
            else
                s+=c[i];
        return s;
    }
}