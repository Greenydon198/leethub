class Solution {
    public String countAndSay(int n) {
         if(n==1)
            return "1";
        String s = "1";
        for(int i=2;i<=n;i++){
            int c=0;
            char t = s.charAt(s.length()-1); 
            String ts ="";
            for(int j =s.length()-1;j>=0;j--){
                if( s.charAt(j)==t)
                    c++;
                else{
                    ts=c+""+t+""+ts;
                    c=1;
                    t=s.charAt(j);
                }
            }
            ts=c+""+t+""+ts;
            s=ts;
        }
        return s;
    }
}