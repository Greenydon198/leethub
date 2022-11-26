class Solution {
    public void moveZeroes(int[] a) {
        int i=0,j=0,n=a.length;
        while(i<n){
            if(a[i]!=0){
                int t = a[i];
                a[i]=a[j];
                a[j]=t;
                i++;j++;
            }
            else if(a[i]==0)i++;
        }
        
    }
}