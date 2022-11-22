class Solution {
    public String removeStars(String s) {
        int l = s.length();
        ArrayList<Character> a = new ArrayList<>();
        int ind = -1;
        for(int i=0;i<l;i++)
            if('*'==s.charAt(i)){
                a.remove(ind--);
            }
            else{
                a.add(s.charAt(i));
                ind++;
            }
        char c[] = new char[a.size()];
        // String ss = "";
        for(int i=0;i<a.size();i++)
            c[i] = a.get(i);
            // ss +=a.get(i);
        return new String(c);
        // return ss;
    }
}