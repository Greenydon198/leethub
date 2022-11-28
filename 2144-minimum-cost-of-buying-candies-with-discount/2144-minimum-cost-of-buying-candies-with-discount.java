class Solution {
    public int minimumCost(int[] a) {
        Arrays.sort(a);
        int s=0;
        for(int i=a.length-1;i>=0;i-=3){
            if(i!=0)s+=a[i]+a[i-1];
            else
                s+=a[i];
        }   
        return s;
    }
}