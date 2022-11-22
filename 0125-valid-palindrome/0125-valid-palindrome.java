class Solution {
    public boolean isPalindrome(String s) {
     ArrayList<Character> t = new ArrayList<>();
    s= s.toLowerCase();
    for(int i=0;i<s.length();i++)
        if((s.charAt(i)>='a' && s.charAt(i)<='z')||(s.charAt(i)>='0'&& s.charAt(i)<='9'))
            t.add(s.charAt(i));
        return flag(t,0,t.size()-1);
    }
    public static boolean flag(ArrayList<Character> t,int i,int j){
    if(i>=j)return true;
    if(t.get(i)==t.get(j))
        return flag(t,i+1,j-1);
    else 
        return false;
    }
}