//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String args[]) {
        // taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking total number of elements
            int n = sc.nextInt();

            // taking size of subArrays
            int k = sc.nextInt();

            // Declaring and Intializing an array of size n
            int arr[] = new int[n];

            // adding all the elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Calling the method max_of_subarrays of class solve
            // and storing the result in an ArrayList
            ArrayList<Integer> res = new Solution().max_of_subarrays(arr, n, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    static ArrayList<Integer> max_of_subarrays(int a[], int n, int k) {
        int nge[] = nger(a,n);
        ArrayList<Integer> ans = new ArrayList<Integer>();
		int i=0,j=0;
		while(i<=n-k){
			if(j>=i && nge[j]>=i+k){
				ans.add(a[j]);
				i++;
			}
			else j++;
		}
		return ans;
	}
	static int[] nger(int a[],int n){
		Stack <Integer> st = new Stack<>();
		int ans[] = new int[n];
		for(int i=0;i<n;i++){
			while(!st.empty() && a[i]>a[st.peek()])ans[st.pop()]=i;
			st.push(i);
		}
		while(!st.empty())ans[st.pop()] = n;
		// System.out.println(Arrays.toString(ans));
		return ans;
	}
}