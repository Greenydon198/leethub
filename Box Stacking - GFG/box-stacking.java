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
            String[] s1 = br.readLine().trim().split(" ");
            int[] height = new int[n];
            for(int i = 0; i < n; i++){
                height[i] = Integer.parseInt(s1[i]);
            }
            String[] s2 = br.readLine().trim().split(" ");
            int[] width = new int[n];
            for(int i = 0; i < n; i++){
                width[i] = Integer.parseInt(s2[i]);
            }
            String[] s3 = br.readLine().trim().split(" ");
            int[] length = new int[n];
            for(int i = 0; i < n; i++){
                length[i] = Integer.parseInt(s3[i]);
            }
            Solution obj = new Solution();
            System.out.println(obj.maxHeight(height, width, length, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class dimensions implements Comparable<dimensions>{
	int h;
	int l;
	int w;
	dimensions(int h,int l,int w){
		this.h = h;
		this.l = l;
		this.w = w;
	}

	public int compareTo(dimensions x){
		return this.l-x.l;
	}
}

class Solution
{
    public static int maxHeight(int[] h, int[] w, int[] l, int n)
    {
        //Write your code here 
		dimensions a[] = new dimensions[n*6];
		int ind = 0;
		for(int i=0;i<n;i++){
			a[ind++] = new dimensions(h[i],w[i],l[i]);
			a[ind++] = new dimensions(h[i],l[i],w[i]);
			a[ind++] = new dimensions(w[i],h[i],l[i]);
			a[ind++] = new dimensions(w[i],l[i],h[i]);
			a[ind++] = new dimensions(l[i],h[i],w[i]);
			a[ind++] = new dimensions(l[i],w[i],h[i]);
		}

		Arrays.sort(a);

		int ans = 0;
		int sto[] = new int[n*6];
		for(int i=0;i<n*6;i++){
			int max = 0;
			for(int j=i-1;j>=0;j--){
				if(a[i].l>a[j].l && a[i].w>a[j].w){
					max = Math.max(max,sto[j]);
				}
			}
			sto[i] = max + a[i].h;
			ans = Math.max(ans,sto[i]);
		}

		// for(dimensions i:a){
		// 	System.out.println(i.h +" "+i.l+" "+i.w);
		// }
		return ans;
    }
}