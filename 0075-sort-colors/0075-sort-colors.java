class Solution {
    public void sortColors(int[] a) {
        int c0=0,c1=0,n=a.length;
        for(int i=0;i<n;i++){
            if(a[i]==0)c0++;
            else if(a[i]==1)c1++;
        }
        for(int i=0;i<n;i++){
            if(c0>i)a[i]=0;
            else if(c0+c1>i)a[i]=1;
            else
                a[i]=2;
        }
    }
}