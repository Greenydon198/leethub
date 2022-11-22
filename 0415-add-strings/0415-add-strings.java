class Solution {
    public String addStrings(String n1, String n2) {
        ArrayList <Integer> a = new ArrayList<>();
        char c[] = n1.toCharArray();
        char d[] = n2.toCharArray();
        int cc=0;
        for(int i=c.length-1,j=d.length-1;i>=0 || j>=0;){
            if(i>=0 && j>=0){
                a.add(((c[i]-'0')+(d[j]-'0')+cc)%10);
                cc=(((c[i]-'0')+(d[j]-'0')+cc)/10);
                i--;j--;
                   }
            else if(i>=0){
                a.add(((c[i]-'0')+cc)%10);
                cc=(((c[i]-'0')+cc)/10);
                i--;}
            else if(j>=0){
                a.add(((d[j]-'0')+cc)%10);
                cc=(((d[j]-'0')+cc)/10);
                j--;
            }
        }
        if(cc>0)
            a.add(cc);
        String s="";
        for(int i=a.size()-1;i>=0;i--)
            s+=Integer.toString(a.get(i));
        return s;
    }
}