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
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.isStrong(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int isStrong(int n) {
        // code here
        int s=0,nn=n;
        while(n>0){
            s+=primefact(n%10);
            n/=10;
        }
        return (s==nn)?1:0;
    }
    public static int primefact(int n){
		if(n==1|| n==0)return 1;
		else if (n==2)return 2;
		else if (n==3)return 6;
		else if (n==4)return 24;
		else if (n==5)return 120;
		else if (n==6)return 720;
		else if (n==7)return 5040;
		else if (n==8)return 40320;
		else if (n==9)return 362880;
		return 1;
	 }
};