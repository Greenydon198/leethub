//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maximumSumRectangle(N, M, a));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int maximumSumRectangle(int r, int c, int a[][]) {
        // code here
        int max = Integer.MIN_VALUE;
        for(int m=0;m<r;m++){
            int t[] = a[m];
            int temp = 0;
            for(int x:t){
                temp +=x;
                max = Math.max(max,temp);
                if(temp<0)temp=0;
            }
            for(int i=m+1;i<r;i++){
                temp = 0;
                for(int j=0;j<c;j++){
                    t[j] += a[i][j];
                    temp += t[j];
                    max = Math.max(max,temp);
                    if(temp<0)temp=0;
                }
            }
        }
        return max;
    }
};