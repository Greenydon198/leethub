//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    int k = Integer.parseInt(br.readLine().trim());
		    
		    Solution ob= new Solution();
		    System.out.println(ob.countKdivPairs(arr, n, k));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static long countKdivPairs(int a[], int n, int k)
    {
        //code here
        Map<Integer,Integer> hm = new HashMap<>();
		long count =0;
		for(int i:a){
			int rem = i%k;
			if(rem == 0)
				count+=hm.getOrDefault(0,0);
			else{
				count+=hm.getOrDefault(k-rem,0);
			}
			hm.put(rem,hm.getOrDefault(rem,0)+1);
			// System.out.println(hm+" "+rem+" "+(k-rem)+" "+count);
		}
		return count;
    }
}