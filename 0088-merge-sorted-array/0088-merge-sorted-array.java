class Solution {
    public void merge(int[] a, int m, int[] b, int n) {
        int c[] = new int[m+n];
        int t=0;
        for(int i = 0,j=0,fi=0,fj=0;i+j<m+n;){
            if(i==m)fi=1;
            if(j==n)fj=1;
            if(fj==1||(fi==0 && a[i]<=b[j])){
                c[t++]=a[i];
                i++;}
            else {
                c[t++]=b[j];
                j++;}
        }
        for(int i=0;i<c.length;i++)
            a[i]=c[i];
    }
}