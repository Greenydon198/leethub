//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int a[], int n) {
        // code here
        int dup = 0,miss =0;
        for(int i=0;i<n;i++){
            int x = Math.abs(a[i])-1;
            if(a[x]>0)
                a[x] *= -1;
            else
                dup = x + 1;
        }
        
        for(int i=0;i<n;i++)
            if(a[i]>0)miss = i+1;
            
        return new int[]{dup,miss};
    }
}