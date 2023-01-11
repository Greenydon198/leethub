//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}



// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {
        
        // Your code here
        int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int maxsum = 0;
		int minsum = 0;
		int total = 0;
		for(int i=0;i<n;i++){
			total +=a[i];
			maxsum +=a[i];
			max = Math.max(maxsum,max);
			if(maxsum<0)maxsum = 0;
			minsum +=a[i];
			min = Math.min(minsum,min);
			if(minsum>0)minsum = 0;
		}
		// System.out.println(total+" "+min+" "+max);
        if(max<=0)return max;
		return Math.max(max,total-min);
    }
    
}

