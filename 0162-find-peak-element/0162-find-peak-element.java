class Solution {
    public int findPeakElement(int[] a) {
        if(a.length==1)return 0;
        if(a[a.length-1]>a[a.length-2])return a.length-1;
        if(a[0]>a[1])return 0;
        for(int i=a.length-2;i>=1;i--)
            if(a[i]>a[i+1]&&a[i]>a[i-1])
                return i;
        return 0;
    }
}