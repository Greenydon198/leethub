class Solution {
    public int[] twoSum(int[] a, int k) {
        int b[] = a.clone();
        Arrays.sort(a);
        int l=0,r=a.length-1;
        while(l<r){
            if(a[l]+a[r]==k){
                l=a[l];r=a[r];
                break;
            }
            if(a[l]+a[r]>k)
                r--;
            if(a[l]+a[r]<k)
                l++;
        }
        int li=0,ri=0;
        for(int i=0;i<b.length;i++){
            if(l==b[i]){
                li=i;
                break;}
        }
        for(int i=b.length-1;i>0;i--){
            if(r==b[i]){
                ri=i;
                break;}
        }
        return new int[]{li,ri};
    }
}