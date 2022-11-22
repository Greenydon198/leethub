class Solution {
    public String reverseWords(String s) {
        String st[] = s.split(" ");
        String news="";
        String n[] = new String[st.length];
        int t =0;
        for(int i=st.length-1;i>=0;i--){
                if(st[i].equals(""))
                        continue;
               n[t++]=st[i];
        }   
        for(int i=0;i<t-1;i++)
            news+=n[i]+" ";
        return news+n[t-1];
    }
}