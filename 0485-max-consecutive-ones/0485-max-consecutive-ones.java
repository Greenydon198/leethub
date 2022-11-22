class Solution {
    public int findMaxConsecutiveOnes(int[] a) {
        int c =0,f=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==1)
                c++;
            else if(a[i]==0)
                c=0;
            f=Math.max(f,c);
        }
        return f;
    }
}