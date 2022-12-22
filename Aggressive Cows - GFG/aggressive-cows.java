//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] a) {
        if(k>n)return 0;
        Arrays.sort(a);
        int s = 1;
        int e = a[n-1];
        int ans = 0;
        // System.out.println(Arrays.toString(a));
        while(s<=e){
            int mid = (s+e)/2;
            // System.out.println(mid+" "+s+" "+e+" "+ans);
            if(check(a,n,k,mid)){
               s=mid+1;
               ans = mid;
            }
            else{
                 e = mid-1;
            }
        }
        return ans;
    }
    static boolean check(int a[],int n,int k,int m){
        int currpos = 0;
        for(int i=1;i<n;i++){
            if(a[i]-a[currpos]>=m){
                currpos=i;
                k--;
            }
        }
        return (k<=1);
    }
}