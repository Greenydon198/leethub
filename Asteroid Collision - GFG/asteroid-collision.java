//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int n, int[] a) {
        // code here
		Stack <Integer> st = new Stack<>();
		for(int i=0;i<n;i++){
			// if(a[i]<0 && st.size()>0 && st.peek()>0){
			boolean f = true;
			while(a[i]<0 && st.size()>0 && st.peek()>0){
				if(-a[i]>st.peek())st.pop();
				else if(-a[i]==st.peek()){
					st.pop();
					f=false;
					break;
				}
				else if(-a[i]<st.peek()){
					f=false;
					break;
				}
			}
			if(f)
				st.push(a[i]);
			// }
			// System.out.println(st);
		}
		int ans[] = new int[st.size()];
		for(int i=st.size()-1;i>=0;i--)ans[i] = st.pop();
		return ans;
    }
}
