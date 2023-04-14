//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    void KswapPermutation(long a[] ,int n,int b){
        int ind[] = new int[n+1];
		for(int i=0;i<n;i++){
			ind[(int)a[i]]=i;
		}

		int curr = n;
		while(curr>0 && b>0){
			if(a[n-curr]==curr){
				curr--;
				continue;
			}
			int curr_ind = ind[curr];
			int temp = (int)a[n-curr];
			a[n-curr] = curr;
			a[curr_ind] = temp;
			ind[temp] = curr_ind;
			b--;
			curr--;
		}
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while(testcases-- > 0){
            //int n=Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] a2 = line.trim().split("\\s+");
            int n =Integer.parseInt(a2[0]);
            int k =Integer.parseInt(a2[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long arr[]=new long[n];
            for(int  i=0;i<n;i++)
            {
                arr[i]=Long.parseLong(a1[i]);
            }
            Solution ob=new Solution();
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            ob.KswapPermutation(arr,n,k);
            for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");
            System.out.println();
        }
    }
}





// } Driver Code Ends