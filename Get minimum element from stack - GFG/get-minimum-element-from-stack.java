//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends


class GfG
{
    Stack<Integer> st;
	Stack<Integer> min;
    
	GfG()
	{
		st = new Stack<Integer>();
		min = new Stack<Integer>();
	}

	void push(int x){
        //Write Code here
		if(st.empty()){
			min.push(x);
		}
		else{
			min.push(Math.min(x,min.peek()));
		}
		st.push(x);
    }
	
	int pop(){
        //Write Code here
		if(st.empty())
			return -1;
		min.pop();
		return st.pop();
	}

    int getMin(){
        //Write Code here
		if(min.empty())return -1;
		return min.peek();
	}	
}

