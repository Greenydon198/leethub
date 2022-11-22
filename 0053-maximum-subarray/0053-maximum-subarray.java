class Solution {
    public int maxSubArray(int[] a) {
        int l = a.length-1;
        int current = 0;
        int finals=Integer.MIN_VALUE;
        for(int i=0;i<=l;i++){
            int f=a[i];
            int sec=a[i]+current;
            current=Math.max(f,sec);
            finals=Math.max(finals,current);
        }
        // for(int j=0;j<=l;){
        //     tc+=a[j];
        //     s = (tc>s)?tc:s;
        // }
        return finals;
    }
}