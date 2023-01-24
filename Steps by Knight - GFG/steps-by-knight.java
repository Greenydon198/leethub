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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int c[], int k[], int n){
        // Code here
        boolean visit[][] = new boolean[n+1][n+1];
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(c[0],c[1],0));
        visit[c[0]][c[1]] = true;
        while(q.size()>0){
            int i = q.peek().i;
            int j = q.peek().j;
            int w = q.remove().w;
            
            if(i==k[0] && j==k[1])return w;
            for(int x=0;x<8;x++){
                int ni = i + di[x];
                int nj = j + dj[x];
                
                if(ni<1 || nj<1 || ni>n || nj>n)continue;
                if(!visit[ni][nj]){
                    visit[ni][nj] = true;
                    q.add(new pair(ni,nj,w+1));
                }
            }
        }
        return -1;
    }
    
    
    int di[] = {-2,2,-2,2,-1,1,-1,1};
    int dj[] = {-1,-1,1,1,2,2,-2,-2};
    
    class pair{
        int i;
        int j;
        int w;
        pair(int ii,int jj,int wt){
            i=ii;
            j=jj;
            w=wt;
        }
    }
}