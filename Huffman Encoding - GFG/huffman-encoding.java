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
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            int N = S.length();
            Solution ob = new Solution();
            String[] element = br.readLine().trim().split("\\s+");
		    int[] f = new int[N];
		    for(int i = 0; i < N; i++){
		        f[i] = Integer.parseInt(element[i]);
		    }
            ArrayList<String> res  = ob.huffmanCodes(S,f,N);
            for(int i = 0; i < res.size(); i++)
            {
                System.out.print(res.get(i)+" ");
            }
            System.out.println();
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    public ArrayList<String> huffmanCodes(String S, int f[], int n)
    {
        // Code here
        Node pre = null;
		ArrayList<String> ans = new ArrayList<String>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int i=0;i<n;i++)
			pq.add(new Node(f[i],S.charAt(i)));
		// System.out.println(pq);
		while(pq.size()>1){
			Node left = pq.remove();
			Node right = pq.remove();
			Node root = new Node(left.data+right.data,left,right);
			pq.add(root);
			// System.out.println(pq);
		}
		trav(pq.remove(),"",ans);
		return ans;
    }    

	private void trav(Node root,String s,ArrayList<String> ans){
		if(root==null)return;
		if(root.c!=null)ans.add(s);
		
		trav(root.left,s+"0",ans);
		trav(root.right,s+"1",ans);
    }
}

class Node implements Comparable<Node>{
	int data;
	Node left;
	Node right;
	Character c;
	Node(int d,char t){
		data = d;
		c = t;
	}

	Node(int d,Node l,Node r){
		data = d;
		left = l;
		right = r;
	}

	public int compareTo(Node s){
		if(this.data==s.data)return 1;
		return this.data-s.data;
	}

}