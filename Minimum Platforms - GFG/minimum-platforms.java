//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        pair a[] = new pair[n];
        for(int i=0;i<n;i++){
            a[i] = new pair(arr[i],dep[i]);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = 1;
        Arrays.sort(a);
        pq.add(a[0].d);
        
        for(int i=1;i<n;i++){
            if(pq.peek()>=a[i].a){
                max++;
            }
            else
                pq.remove();
            
            pq.add(a[i].d);
        }
        
        return max;
    }
}

class pair implements Comparable<pair>{
    int a;
    int d;
    pair(int aa,int dd){
        a = aa;
        d = dd;
    }
    
    public int compareTo(pair C){
        return this.a - C.a;
    }
}

