//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minInsertions(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int minInsertions(int a[], int n) 
	{ 
        //code here.
        int dpinc[] = new int[n];
        int lis = 0;
        
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(a[i]>=a[j]){
                    dpinc[i] = Math.max(dpinc[i],dpinc[j]);
                }
            }
            dpinc[i]++;
            lis = Math.max(lis,dpinc[i]);
        }
        return n-lis;
	} 
}
