//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int p[], int n) {
        ind = n-1;
        return trav(p,in,0,n-1);
        // trav(root,p,in,rootpos+1,in.length-1);
        // return root; 
    }
    int ind;
     Node trav(int p[],int in[],int s,int e){
        if(s>e){
            return null;
        }
        int temp = p[ind--];
        Node root = new Node(temp);
        int mid = pos(in,temp,s,e);
        root.right = trav(p,in,mid+1,e);
        root.left = trav(p,in,s,mid-1);
        return root;
        
    }
     int pos(int in[],int temp,int s,int e){
        while(s<=e)if(temp==in[s++])return s-1;
        return -1;
    }
}
