//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine().trim());
            String input_line[] = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubsequence(N, A));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubsequence(int N, int a[])
    {
        // code here
        Map<Integer,Integer> hm = new HashMap<>();
		int max = 0;
        for(int i:a){
			int small = hm.getOrDefault(i-1,0);
			int large = hm.getOrDefault(i+1,0);
			int value = Math.max(small,large)+1;
			max = Math.max(max,value);
			hm.put(i,value);
        }
        return max;
    }
}