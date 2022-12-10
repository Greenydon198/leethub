//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity1(int a[][], int n)
    {
    	// code here 
    	for(int i=0;i<n;i++){
			boolean f = true;
			for(int j=0;j<n;j++){
				if(i==j)continue;
				if(a[i][j]!=0 || a[j][i]!=1){
					f=false;
					break;
				}
			}
			if(f)return i;
		}
		return -1;
    }
    int celebrity(int a[][], int n){
		for(int i=0;i<2;i++){
			for(int j=0;j<n;j++){
				if(i==j)continue;
				if(a[i][j]==1){
					boolean f=true;
					for(int k=0;k<n;k++){
						if(k==j)continue;
						if(a[j][k]!=0 || a[k][j]!=1){
						f=false;
						break;
						}
					}
					if(f)return j;
				}
			}
		}
		return -1;
	}
}