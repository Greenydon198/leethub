//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int a[], int n)
    {
        // Your code here
        //starting point (s) =0;
        //iterate for(i=0 till size)
        // place the +ve values in thier index values of array
        // iterate for(i=0 till size)to check for missing values like i!= a[i]
        // if not found return n
        //3 1 2
        //2 1 3
        //1 2 3
        //i & j till size
        //3 -1 2 4
        //2 -1 3 4 j++
        //-1 2 3 4 j++
        // int i =0,j=0;
        // while(j<n){
        //     if(a[i]<=n && a[i]>0){
        //         int temp = a[i];
        //         a[i] = a[a[i]-1];
        //         a[a[i]-1] = temp;
        //     }
        //     if(a[i]==i-1 || a[i]>n || a[i]<=0)i++;
        //     j++;
        // }
        // for(int i=0;i<n;i++){
        //     if(a[i]<=n && a[i]>0){
        //         while(a[i]!=a[a[i]-1]){
        //             int  
        //         }
        // }
        int freq[] = new int[n+1];
        for(int i=0;i<n;i++)
            if(a[i]<=n && a[i]>0)
                freq[a[i]]=1;
                
        for(int s=1;s<=n;s++)
            if(freq[s]!=1)return s;
        return n+1;
        
    }
}


//{ Driver Code Starts.

class Main
{   
    public static void main (String[] args) 
    {

		Scanner sc=new Scanner(System.in);
		
        //taking testcases
		int t=sc.nextInt();
		while(t-->0){
		    
		    //input number n
			int n=sc.nextInt();
			int[] arr=new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			System.out.println(missing);
		}
    }
}


// } Driver Code Ends