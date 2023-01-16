//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Main {
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        }
	}
	
	 public static void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}


// } Driver Code Ends


//User function Template for Java


class GFG 
{
    //Function to construct the BST from its given level order traversal.
    public Node constructBST(int[] a)
    {
        //Write your code here 
        int ind = 1;
		Queue<pair> q = new LinkedList<>();
		Node root = new Node(a[0]);
		q.add(new pair(root,Integer.MIN_VALUE,a[0],true));
		q.add(new pair(root,a[0],Integer.MAX_VALUE,false));
		while(ind<a.length && q.size()>0){
			pair temp = q.remove();
			if(a[ind]<temp.max && a[ind]>temp.min){
				if(temp.lr){
					temp.root.left = new Node(a[ind]);
					q.add(new pair(temp.root.left,temp.min,a[ind],true));
					q.add(new pair(temp.root.left,a[ind],temp.max,false));
					ind++;
					}
				else{
					temp.root.right = new Node(a[ind]);
					q.add(new pair(temp.root.right,temp.min,a[ind],true));
					q.add(new pair(temp.root.right,a[ind],temp.max,false));
					ind++;
				}
			}
			// System.out.println(q);
		}
		return root;
    }
}

class pair{
	Node root;
	int max;
	int min;
	boolean lr;
	pair(Node root,int min,int max,boolean lr){
		this.root = root;
		this.max = max;
		this.min = min;
		this.lr = lr;
	}
}