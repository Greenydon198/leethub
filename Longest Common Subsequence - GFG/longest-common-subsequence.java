//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        char[] a = s1.toCharArray();
		char[] b = s2.toCharArray();
        return memo(0,0,a,b,new Integer[x][y]);

		//tabular appraoch
// 		int sto[][] = new int[x+1][y+1];
// 		for(int i=1;i<=x;i++){
// 			for(int j=1;j<=y;j++){
// 				if(a[i-1]==b[j-1])sto[i][j] = 1 + sto[i-1][j-1];
// 				else{
// 					sto[i][j] = Math.max(sto[i-1][j],sto[i][j-1]);
// 				}
// 			}
// 		}

// 		return sto[x][y];
    }

	private static int memo(int i,int j,char[] a,char b[],Integer sto[][]){
		if(i>=a.length || j>=b.length)return 0;
		if(sto[i][j]!=null)return sto[i][j];
		
		if(a[i]==b[j]){
			sto[i][j] =  1 + memo(i+1,j+1,a,b,sto);
			return sto[i][j];
		}

		int c1 = memo(i+1,j,a,b,sto);
		int c2 = memo(i,j+1,a,b,sto);
		sto[i][j] = Math.max(c1,c2);
		return sto[i][j];
	}
    
}