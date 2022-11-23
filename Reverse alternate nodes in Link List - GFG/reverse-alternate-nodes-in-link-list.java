//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution
{
    public void rearrange(Node head)
    {
        // add your code here
		if(head==null || head.next==null || head.next.next==null)return;
		Node c = head.next.next;
		while(c!=null){
			aod(c.data);
			if(c.next!=null && c.next.next!=null)
				c=c.next.next;
			else
				break;
		}
		c = head.next;
		while(c!=null){
			aed(c.data);
			if(c.next!=null && c.next.next!=null)
				c=c.next.next;
			else
				break;
		}
		tod.next=ted;
		head.next=hod;
    }
	Node hod;
	Node tod;
	Node hed;
	Node ted;

	 void aod(int d){
		Node nn = new Node(d);
		if(hod==null){
			hod=nn;
			tod=nn;
		}
		else{
			tod.next=nn;
			tod=nn;
		}
	}
	 void aed(int d){
		Node nn = new Node(d);
		if(hed==null){
			hed=nn;
			ted=nn;
		}
		else{
			nn.next=ted;
			ted=nn;
		}
	}
}