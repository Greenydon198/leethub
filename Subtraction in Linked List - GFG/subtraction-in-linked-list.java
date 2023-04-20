//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.subLinkedList(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* Structure of Linked list node

class Node
{
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}

*/

class Solution{
    static Node subLinkedList(Node n1, Node n2){
        // code here
        len = new int[]{0,0};
        ind = 0;
        n1 = removezero(n1);
        n2 = removezero(n2);
		n1 = reverse(n1);
		n2 = reverse(n2);
		// System.out.println(len[0]+" "+len[1]);
		// trav(n1,n2);
		
		Node ans = new Node(0);
		if(len[0]>len[1]){
			sub(n1,n2);
			ans = n1;
		}
		else if(len[0]<len[1]){
			sub(n2,n1);
			ans = n2;
		}
		else{
			Node c1 = n1;
			Node c2 = n2;
			Node big=n1,small=n2;
			while(c1!=null){
				if(c1.data==c2.data);
				else if(c1.data>c2.data){
					big = n1;
					small = n2;
				}
				else{
					big = n2;
					small = n1;
				} 
				c1 = c1.next;
				c2 = c2.next;
			}
			sub(big,small);
			ans = big;
		}
		// trav(ans,n2);
		ind = 0;
		ans = reverse(ans);
		
		ans = removezero(ans);
		
		return ans;
    }

static int len[];
static int ind;

	static Node reverse(Node head){
		Node p = null;
		int clen = 0;
		while(head!=null){
			Node f = head.next;
			head.next = p;
			p = head;
			head = f;
			clen++;
		}
		len[ind++] = clen;
		return p;
	}

	static void sub(Node n1,Node n2){
		int carry = 0;
		while(n2!=null){
			n1.data -= carry;
			if(n1.data<0)
			    n1.data = 9;
			else
			    carry = 0;
			if(n1.data >= n2.data)
				n1.data = n1.data-n2.data;
			else{
				carry++;
				n1.data = 10 + n1.data - n2.data;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		while(carry>0){
		    n1.data-=1;
		    if(n1.data<0)
			    n1.data = 9;
			else
			    carry = 0;
		    n1 = n1.next;
		}
		    
	}

	static Node removezero(Node head){
	    Node pre = null;
		while(head!=null && head.next!=null && head.data==0){
		    pre = head;
		    head = head.next;
		}
		if(pre!=null)pre.next = null;
		return head;
    }
}