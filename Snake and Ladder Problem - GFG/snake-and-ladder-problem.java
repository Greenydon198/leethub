//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[2*N];
            for(int i = 0;i < 2*N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minThrow(N, arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minThrow(int n, int a[]){
        // code here
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<2*n;){
            hm.put(a[i++],a[i++]);
        }
        // System.out.println(hm);
        Queue<Integer> q = new LinkedList<>();
        boolean visit[] = new boolean[37];
        q.add(1);
        visit[1] = true;
        int cnt = 0;
        while(q.size()>0){
            int len = q.size();
            while(len-->0){
                int s = q.remove();
                if(s==30)return cnt;
                for(int i=1;i<=6;i++){
                    int ni = i+s;
                    if(!visit[ni]){
                        if(hm.containsKey(ni)){
                            q.add(hm.get(ni));
                            visit[hm.get(ni)] = true;
                        }
                        q.add(ni);
                        visit[ni] = true;
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }
}