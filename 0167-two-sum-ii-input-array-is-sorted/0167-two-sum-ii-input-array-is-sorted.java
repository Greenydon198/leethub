class Solution {
    public int[] twoSum(int[] a, int k) {
        int i = 0,j=a.length-1;
        while(i<j){
            if(a[i]+a[j]==k){
               return new int[]{i+1,j+1};
            }
            else if(a[i]+a[j]>k)
                j--;
            else if(a[i]+a[j]<k)
                i++;
            
        }
        return new int[]{};
    }
}