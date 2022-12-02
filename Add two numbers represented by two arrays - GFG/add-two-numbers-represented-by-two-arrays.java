//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
  
    String calc_Sum(int a[], int n, int b[], int m)
    {
        // Complete the function
        StringBuilder ar = new StringBuilder();
		int a1 = n-1;
		int b1 = m-1;
		int carry =0;
		while(b1>=0 && a1>=0){
			int s= a[a1--]+carry+b[b1--];
			ar.append(s%10);
			carry = s/10;
		}
		while(b1>=0){
			int s= carry+b[b1--];
			ar.append(s%10);
			carry = s/10;
		}
		while(a1>=0){
			int s= carry+a[a1--];
			ar.append(s%10);
			carry = s/10;
		}
		if(carry==1)
			ar.append(carry);
		for(int i=ar.length()-1;i>=0;i--){
		    if(ar.charAt(i)=='0')
		    ar.deleteCharAt(i);
		    else
		    break;
		}
		return ar.reverse().toString();
    }
  
    
}


//{ Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray_N = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray_N];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray_N;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    String line2 = br.readLine();
		    String[] ele = line2.trim().split("\\s+");
		    int sizeOfArray_M = Integer.parseInt(ele[0]);
		    
		    int brr [] = new int[sizeOfArray_M];
		    
		    line2 = br.readLine();
		    String[] elements2 = line2.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray_M;i++){
		        brr[i] = Integer.parseInt(elements2[i]);
		    }
		    
		    Solution obj = new Solution();
		   
		    String res = obj.calc_Sum(arr, sizeOfArray_N, brr, sizeOfArray_M);
		    
		    System.out.println(res);
		    
		    
		}
	}
}


            


// } Driver Code Ends