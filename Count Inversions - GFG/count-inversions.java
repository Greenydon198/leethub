//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long a[], long N)
    {
        // Your Code Here
        count = 0;
        sort(a,0,a.length-1);
        // System.out.println(Arrays.toString(a));
        return count;
    }
    
    static long count = 0;
    static void sort(long a[],int s,int e){
        if(s>=e)return;
        
        int mid = ((e-s)/2)+s;
        
        sort(a,s,mid);
        sort(a,mid+1,e);
        merge(a,s,mid,e);
    }
    
    static void merge(long a[],int s,int mid,int e){
        ArrayList<Long> temp = new ArrayList<>();
        int i = s,j=mid+1;
        while(i<=mid && j<=e){
            if(a[i]<=a[j])temp.add(a[i++]);
            else{
                temp.add(a[j++]);
                count+= mid-i+1;
            }
        }
        while(i<=mid){
            temp.add(a[i++]);
        }
        while(j<=e){
            temp.add(a[j++]);
        }
        
        i=0;
        
        while(s<=e){
            a[s++] = temp.get(i++);
        }
    }
}