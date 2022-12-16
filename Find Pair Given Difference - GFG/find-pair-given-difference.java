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
    public boolean findPair(int a[], int n, int k)
    {
        //code here.
        Map<Integer,Integer> hm = new HashMap<>();
		for(int i=0;i<n;i++){
		    if(hm.containsKey(a[i]))hm.put(a[i],hm.get(a[i])+1);
			else hm.put(a[i],1);
		}
		for(int i:hm.keySet())
			if(k!=0 && hm.containsKey(k+i))return true;
			else if(k==0 && hm.get(i)>1)return true;
		return false;
    }
}