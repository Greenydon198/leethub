class Solution {
    public int findPairs(int[] a, int k) {
        int c=0;
        Arrays.sort(a);
        int t =-100000000;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length && a[i]!=t;j++)
                if(a[j]-a[i]==k){
                    c++;
                    break;
                }
            else if(a[j]-a[i]>k)
                break;
            t=a[i];
        }
        return c;
    }
}