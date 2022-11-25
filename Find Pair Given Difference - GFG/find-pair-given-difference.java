//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int l = sc.nextInt();
            int n = sc.nextInt();
            
            int arr[] =  new int[l];
            
            for(int i = 0;i<l;i++)
                arr[i] = sc.nextInt();
            
            Solution ob = new Solution();
                
            if(ob.findPair(arr, l, n)==true)
                System.out.println(1);
                
            else
                System.out.println(-1);    
                
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean findPair(int A[], int n, int k)
    {
        //code here.
        Arrays.sort(A);
		int s=0,e=1;
		while(e!=n){
			if(A[e]-A[s]==k)
				return true;
			else if(s+1==e || A[e]-A[s]<k)
				e++;
			else if(A[e]-A[s]>k)
				s++;			
		}
		return false;
    }
}