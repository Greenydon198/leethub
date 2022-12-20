//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-- > 0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.findElement(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class Compute {
    public int findElement(int a[], int n){
		for(int i=1;i<n-1;i++){
			boolean f = true;
			for(int j=i+1;j<n && f;j++){
				if(a[i]>a[j]){
					f=false;
				}
				
			}
			for(int j=i-1;j>=0 && f;j--){
				if(a[i]<a[j]){
					f=false;
				}
			}
			if(f){
				return a[i];
			}
		}
		return -1;
        
    }
}