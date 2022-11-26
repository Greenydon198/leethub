class Solution {
    public void sortColors(int[] a) {
        // if(a[])
        int s=0,e=a.length-1;
        while(s<=e){
            if(a[e]==2)e--;
            else if(a[s]==2){
                int t=a[e];
                a[e--]=a[s];
                a[s]=t;
            }
            else
                s++;   
        }
        s=0;
        while(s<=e){
            if(a[s]==1){
                int t=a[e];
                a[e--]=a[s];
                a[s]=t;
            }
            else
                s++;
        }
    }
}