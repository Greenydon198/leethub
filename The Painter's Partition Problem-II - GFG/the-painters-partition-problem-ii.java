//{ Driver Code Starts
//Initial Template for Java

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
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

 class Solution{
    long minTime(int[] a,int n,int p){//p = no.of painters
        //code here
        int s = 0;
        int e = (int)10e9;
        long ans = -1;
        while(s<=e){
            int mid = (s+e)/2;
            if(check(a,mid,p-1)){
                e = mid -1;
                ans = mid;
            }
            else{
                s = mid+1;
            }
        }
        return ans;
    }
    boolean check(int a[],int cp,int p){//cp = mid = current no.of painters to check
        int currtotal = 0;
        for(int i:a){
            currtotal +=i;
            if(i>cp)return false;
            if(currtotal>cp){
                currtotal = i;
                p--;
            }
        }
        return (p>=0);
    }
}


