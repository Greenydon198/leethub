//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int n, int a[], int k){
        // code here
		return subsetSum(a,n-1,k,new Boolean[n][k+1]);
    }
    
    public static boolean subsetSum(int[] a, int n, int k,Boolean sto[][]){
		if(k==0)return true;
		if(k<0 || n<0)return false;
		
		if(sto[n][k]!=null)return sto[n][k];
		
		sto[n][k] =  subsetSum(a,n-1,k-a[n],sto) || subsetSum(a,n-1,k,sto);
		return sto[n][k];
    }
}