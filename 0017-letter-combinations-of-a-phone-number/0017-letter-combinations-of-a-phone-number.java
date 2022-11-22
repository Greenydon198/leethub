class Solution {
    static String s[] = {null,null,"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String d) {
        int a[] = new int[d.length()];
        for(int i=0;i<d.length();i++)
            a[i]=d.charAt(i)-'0';
        List<String> ans = new ArrayList<>();
        if(d.length()!=0)
            ans=c(0,a);
        return ans;
    }
    public static ArrayList<String> c(int i,int a[]){
        if(i==a.length){
            ArrayList<String> t = new ArrayList<String> ();
            t.add("");
            return t;
        }
        ArrayList<String> f = c(i+1,a);
        ArrayList<String> ans = new ArrayList<String> ();
        for(int x=0;x<s[a[i]].length();x++){
            for(int y=0;y<f.size();y++)
                ans.add(s[a[i]].charAt(x)+f.get(y));
        }
        return ans;
    }
}