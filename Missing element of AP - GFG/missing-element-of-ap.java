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
        // code here
        if(n==2){
            return (a[1]+a[0])/2;
        }
        if(n==3){
            if(a[1]-a[0]<a[2]-a[1]){
                return a[1]+a[1]-a[0];
            }
            else
                return a[2]-a[1]+a[0];
        }
        int freq[] = new int[2];//to check the frequency if diff
        int ap = 0;//to store the difference
        freq[0] = a[1]-a[0];//store the difference of 1st two elements
        freq[1] = -1;
        
        for(int i=1;i<n-1;i++){
            int diff = a[i+1]-a[i];// calculate the diff
            if(diff==freq[0]){
                ap = freq[0];
                break;
            }
            else if(freq[1]==-1){
                freq[1] = diff;
            }
            else{
                ap = freq[1];
                break;
            }
        }
        
        for(int i=0;i<n-1;i++){
            if(a[i]+ap!=a[i+1])return a[i]+ap;// to check the missing element
        }
        
        return 0;
    }
}
