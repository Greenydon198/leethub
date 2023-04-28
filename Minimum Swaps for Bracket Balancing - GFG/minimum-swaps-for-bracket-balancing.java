//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {   
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.minimumNumberOfSwaps(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int minimumNumberOfSwaps(String s){
        // code here
        int swap = 0;
        int c[] = new int[s.length()];
        int cur = 0;
        for(int i=0;i<c.length;i++){
            c[i] = s.charAt(i)=='['?1:-1;
        }
        
        for(int i=0;i<c.length;){
            // System.out.println(cur+" "+i);
            while(c[i]==1 && cur<0){
                int t = c[i];
                c[i] = c[i-1];
                c[i-1] = t;
                cur -= c[i];
                i--;
                swap++;
                // System.out.println(cur+" "+i);
            }
            cur += c[i];
            i++;
        }
        
        return swap;
    }
}