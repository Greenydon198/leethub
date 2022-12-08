//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public long getMaxArea(long a[], long nn) {
        int n = (int)nn;
        int l[] = left(a,n);
		  int r[] = right(a,n);
		  // System.out.println(Arrays.toString(l)+"\n"+Arrays.toString(r));
		  long area = 0;
		  for(int i=0;i<n;i++){
			  area = Math.max(area,a[i]*(l[i]+r[i]+1));
		  }
		  return area;
    }
    	int[] left(long a[],int n){
		Stack<Integer> st = new Stack<>();
		int ans[] = new int[n];
		ans[0]=0;
		st.push(0);
		for(int i=1;i<n;i++){
			while(!st.empty() && a[st.peek()]>=a[i])
				st.pop();
			ans[i]=i-1-((st.empty())?-1:st.peek());
			st.push(i);
		}
		return ans;
	}
	int[] right(long a[],int n){
		Stack<Integer> st = new Stack<>();
		int ans[] = new int[n];
		st.push(n-1);
		ans[n-1]=0;
		for(int i=n-2;i>=0;i--){
			while(!st.empty() && a[st.peek()]>=a[i])
				st.pop();
			ans[i]=((st.empty())?n:st.peek())-i-1;
			st.push(i);
		}
		return ans;
	}
}



