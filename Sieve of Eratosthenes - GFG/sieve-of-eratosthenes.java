//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			
            Solution ob = new Solution();
            ArrayList<Integer> primes  = ob.sieveOfEratosthenes(N);
            for(int prime : primes) {
                System.out.print(prime+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Integer> sieveOfEratosthenes(int n){
        // code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        boolean prime[] = new boolean[n+1];
        for(int i=2;i<=n;i++){
            if(!prime[i]){
                ans.add(i);
                for(int j=i;j<=n;j+=i){
                    prime[j]=true;
                }
            }
            
            prime[i] = true;
        }
        return ans;
    }
}