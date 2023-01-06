//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;
import java.lang.Math;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
class GFG2
{
    public static void inorder(Node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int []post=new int[n];
            for(int i=0;i<n;i++)
            {
                int b=sc.nextInt();
                post[i]=b;
            }
            GFG obj=new GFG();
            Node root=obj.constructTree(post,n);
            inorder(root);
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

// Function should return the root of the bst formed using postorder traversal.
class GFG
{
    public static Node constructTree(int a[],int n)
    {
       return create(a,0,n-1);
    }
	private static Node create(int a[],int s,int e){
		if(s>e)return null;
		Node root = new Node(a[e]);
		int m = mid(a,a[e]);
		root.left = create(a,s,m);
		root.right = create(a,m+1,e-1);
		return root;
	}
	private static int  mid(int a[],int m){
		for(int i=0;i<a.length;i++)
			if(a[i]>=m)return i-1;
		return 0;
	}
}