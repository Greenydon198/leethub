//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N=Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isTriangular(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isTriangular(int n){
        //code here
        // int ans = 0;
        int s= 0;
        int e = n;
        while(s<=e){
            int mid = (s+e)/2;
            int nat = mid*(mid+1)/2;
            if(nat==n)return 1;
            else if(nat<n)s = mid+1;
            else e = mid-1;
        }
        return 0;
    }
}