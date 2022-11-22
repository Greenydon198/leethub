class Solution {
    public int[] twoSum(int[] a, int k) {
        int a1[] = {0,0};
        // int n = a.length;
        // for(int i = 0;i<n;i++)
        //     for(int j = n-1;j>=0;j--)
        //         if(a[i]+a[j]==k){
        //             a1[0] = i+1;
        //             a1[1] = j+1;
        //             i=n;
        //             break;
        // }
        int i = 0,j=a.length-1;
        while(i<j){
            if(a[i]+a[j]==k){
                a1[0] = i+1;
                a1[1] = j+1;
                break;
            }
            else if(a[i]+a[j]>k)
                j--;
            else if(a[i]+a[j]<k)
                i++;
            
        }
        return a1;
    }
}