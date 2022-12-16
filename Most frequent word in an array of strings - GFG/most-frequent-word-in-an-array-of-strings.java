//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    sc.nextLine();
		    Solution obj = new Solution();
		    String arr[]=sc.nextLine().split(" ");
		    System.out.println(obj.mostFrequentWord(arr, n));
		    
		}
	}
}

// } Driver Code Ends
//User function Template for Java


class Solution
{
    //Function to find most frequent word in an array of strings.
    public String mostFrequentWord(String a[],int n)
    {
        // code here
        String ans =a[0];
		Map<String,Integer> hm = new HashMap<>();
		for(int i=0;i<n;i++){
			if(hm.containsKey(a[i]))
				hm.put(a[i],hm.get(a[i])+1);
			else
				hm.put(a[i],1);
		}
		for(int i=0;i<n;i++){
			if(!a[i].equals(ans) && hm.get(ans)<=hm.get(a[i])){
				hm.put(ans,0);
				ans = a[i];
			}
		}
		return ans;
    }

}


//{ Driver Code Starts.
// } Driver Code Ends