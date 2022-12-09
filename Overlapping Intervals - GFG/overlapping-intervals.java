//{ Driver Code Starts
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
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] overlappedInterval(int[][] a)
    {
    int n = a.length;
		 ArrayList <Integer> st = new ArrayList<>();
		Arrays.sort(a,(x,y)->Integer.compare(x[0],y[0]));
		st.add(0);
		for(int i=1;i<n;i++){
			if(a[st.get(st.size()-1)][1]>=a[i][0]){
				a[st.get(st.size()-1)][1]=Math.max(a[st.get(st.size()-1)][1],a[i][1]);
			}
			else{
				st.add(i);
			}
		}
		 int ans[][] = new int[st.size()][2];
		 for(int i=0;i<ans.length;i++){
			 ans[i][0] = a[st.get(i)][0];
			 ans[i][1] = a[st.get(i)][1];
		 }
         return ans;
    }

}