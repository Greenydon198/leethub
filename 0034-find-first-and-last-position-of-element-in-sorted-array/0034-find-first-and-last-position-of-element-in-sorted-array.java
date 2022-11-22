class Solution {
    public int[] searchRange(int[] a, int k) {
        int in[] = {-1,-1};
        int n = a.length;
        for(int i=0;i<n;i++)
            if(k==a[i]){
                in[0]=i;
                break;
            }
        for(int i=n-1;i>-1;i--)
            if(k==a[i]){
                in[1]=i;
                break;
            }
        return in;
    }
}