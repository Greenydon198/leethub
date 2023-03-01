//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] a)
    {
        // Code here
        int dpinc[] = new int[a.length];
        int dpdec[] = new int[a.length];
        int ans = 0;
        
        for(int i=0;i<a.length;i++){
            for(int j=i-1;j>=0;j--){
                if(a[i]>a[j]){
                    dpinc[i] = Math.max(dpinc[i],dpinc[j]);
                }
            }
            dpinc[i]++;
        }
        
        for(int i=a.length-1;i>=0;i--){
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j]){
                    dpdec[i] = Math.max(dpdec[i],dpdec[j]);
                }
            }
            dpdec[i]++;
            ans = Math.max(ans,dpinc[i]+dpdec[i]-1);
        }
        return ans;
    }
}