class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)return false;
        if(n==1)return true;
        long p =1;
        for(int i=0;i<=n && p<=n ;i++){
            p*=2;
        if(p==n)return true;
        }
        return false;
    }
}