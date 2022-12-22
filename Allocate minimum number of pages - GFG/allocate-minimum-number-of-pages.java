//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public int findPages(int[]a,int n,int st)//st=no.of students
    {
        //Your code here
        int max = a[0];
        int total = 0;//total no.of pages
        for(int i:a){
            total+=i;
            max = Math.max(i,max);
        }
        // Arrays.sort(a);
        if(n==st)return max;
        if(n<st)return -1;
        int s = 0;
        int e = total;
        int ans = -1;
        while(s<=e){
            int mid = (s+e)/2;
            // System.out.println(s+" "+mid+" "+e+" "+ans);
            if(check(a,mid,st-1)){
                ans = mid;
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }
        return ans;
    }
    boolean check(int a[],int page,int s){
        int currcount = 0;
        for(int i:a){
            currcount +=i;
            if(i>page)return false;
            if(currcount>page){
                currcount = i;
                s--;
            }
        }
        return (s>=0);
    }
};

















