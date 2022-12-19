//{ Driver Code Starts
//Initial Template for Java




import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMissing(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


//a[[diff1],[diff2]]
//2,2
//4,1
//for(arr)for the difference that occurs more than 1 time
//for(arr)to check the missing element
class Solution {
    int findMissing(int[] a, int n) {
        if(n==2){
            return (a[0]+a[1])/2;
        }
        int AP = Math.min(a[1]-a[0],a[2]-a[1]);
        for(int i=0;i<n-1;i++){
            if(a[i]+AP!=a[i+1])
                return a[i]+AP;
        }
        return 0;
    }
}
