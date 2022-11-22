class Solution {
    public String removeDuplicates(String s) {
        ArrayList<Character> a = new ArrayList<>();
        for(int i=0;i<s.length();i++)
            a.add(s.charAt(i));
        char t = a.get(0);
        for(int i =1;i<a.size();){
            if(t==a.get(i)){
                a.remove(i);
                a.remove(i-1);
                if(a.size()>0 && i==1)t=a.get(0);
                if(a.size()>1 && i>1){
                    t=a.get(i-2);i--;
                }
            }
            else
                t=a.get(i++);
        }
        char c[] = new char[a.size()];
        for(int i=0;i<a.size();i++)
            c[i]=(a.get(i));

        return new String(c);
    }
}