//{ Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
// } Driver Code Ends


class Solution
{
    public static Node buildTree(int in[], int p[], int n)
    {
        ind = 0;
        return trav(p,in,0,n-1);
    }
    static int ind;
    
    static Node trav(int p[],int in[],int s,int e){
        if(s>e){
            return null;
        }
        int temp = p[ind++];
        Node root = new Node(temp);
        int mid = pos(in,temp,s,e);
        root.left = trav(p,in,s,mid-1);
        root.right = trav(p,in,mid+1,e);
        return root;
        
    }
    static int pos(int in[],int temp,int s,int e){
        while(s<=e)if(temp==in[s++])return s-1;
        return -1;
    }
}
