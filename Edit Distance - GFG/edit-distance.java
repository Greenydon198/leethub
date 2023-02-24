//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String s1, String s2) {
        // Code here
        char a[] = s1.toCharArray();
	  char b[] = s2.toCharArray();
	  return memo(a.length-1,b.length-1,a,b,new Integer[a.length][b.length]);
  }

	private int memo(int i,int j,char a[],char b[],Integer sto[][]){
		if(i<0 && j<0)return 0;
		if(i<0 || j<0) return Math.max(i,j)+1;

		if(sto[i][j]!=null)return sto[i][j];
		int res = 0;
		if(a[i]==b[j])
			res = memo(i-1,j-1,a,b,sto);
		else{
			int ins = 1 + memo(i,j-1,a,b,sto);
			int del = 1 + memo(i-1,j,a,b,sto);
			int rep = 1 + memo(i-1,j-1,a,b,sto);
			res = Math.min(ins,Math.min(del,rep));
		}
		sto[i][j] = res; 
		return res;
    }
}