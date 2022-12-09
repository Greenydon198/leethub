//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends


class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    long trappingWater(int a[], int n) { 
        int l[] = leftmax(a,n);
		int r[] = rightmax(a,n);
		long area =0;
		// System.out.println(Arrays.toString(l)+"\n"+Arrays.toString(r));
		for(int i=0;i<n;i++){
			if(l[i]==-1||r[i]==-1)continue;
			area+=Math.min(l[i],r[i])-a[i];
		}
		return area;
    }
	int[] leftmax(int a[],int n){
		Stack<Integer> st = new Stack<>();
		int max = a[0];
		int ans[] = new int[n];
		for(int i=0;i<n;i++){
			if(a[i]>=max){
				max=a[i];
				ans[i] = -1;
			}
			else
				ans[i] = max;
		}
		return ans;
	}
	int[] rightmax(int a[],int n){
		Stack<Integer> st = new Stack<>();
		int max = a[n-1];
		int ans[] = new int[n];
		for(int i=n-1;i>=0;i--){
			if(a[i]>=max){
				max=a[i];
				ans[i] = -1;
			}
			else
				ans[i] = max;
		}
		return ans;
	}
}


