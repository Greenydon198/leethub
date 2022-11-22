class Solution {
    public int maxProfit(int[] a) {
        int min=Integer.MAX_VALUE;
        int p = 0;
        for(int i=0;i<a.length;i++){
            if(min>a[i])
                min=a[i];
            else{
                p=Math.max(p,a[i]-min);
            }
        }
        return p;
    }
}