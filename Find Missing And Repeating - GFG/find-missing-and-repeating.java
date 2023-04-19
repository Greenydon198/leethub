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
        int ans[] = {0,0};
        for(int i=0;i<n;i++){
            while(a[i]!=i+1){
                if(a[i] == a[a[i]-1]){
                    ans[0] = a[i];
                    break;
                }
                
                int t = a[i];
                a[i] = a[t-1];
                a[t-1] = t;
            }
            
            if(ans[0]!=0)break;
        }
        
        long sum = 0;
        for(int i:a)sum+=i;
        sum = ((n*(n+1l))/2) - sum + ans[0];
        ans[1] = (int)sum;
        
        return ans;
    }
}