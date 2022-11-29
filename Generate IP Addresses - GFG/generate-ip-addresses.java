//{ Driver Code Starts
import java.util.*;
class GenIP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution sln = new Solution();
            ArrayList<String> str = sln.genIp(s);
            Collections.sort(str);
            if(str.size() == 0)
                System.out.println(-1);
            else{
                for (String u : str) {
                    System.out.println(u);
                }
            }
        }
    }
}
// } Driver Code Ends


/*complete the Function*/

class Solution {
    public ArrayList<String> genIp(String s) {
        // code here
        int n = s.length();
		if(n<4 ){
			ArrayList<String> ss = new ArrayList<String>();
			ss.add("-1");
			return ss;
		}
		ArrayList<String> fin = new ArrayList<String>();
		int i=1;
		while(i<n-2 &&i<4&& Integer.valueOf(s.substring(0,i))<=255){
			int j=i+1;
			while(j<n-1 &&  j-i<4 && Integer.valueOf(s.substring(i,j))<=255){
				int k = j+1;
				while(k<n &&  k-j<4 &&Integer.valueOf(s.substring(j,k))<=255){
					if(n-k<4 && Integer.valueOf(s.substring(k,n))<=255 ){
					    if(n-k>=2 && s.substring(k,n).charAt(0)!='0'){
						String t = s.substring(0,i)+"."+s.substring(i,j)+"."+s.substring(j,k)+"."+s.substring(k,n);
						fin.add(t);}
						else if(n-k==1){
						    String t = s.substring(0,i)+"."+s.substring(i,j)+"."+s.substring(j,k)+"."+s.substring(k,n);
						    fin.add(t);
						}
					}if(Integer.valueOf(s.substring(j,k))!=0)k++;
					else
						break;
				}if(Integer.valueOf(s.substring(i,j))!=0)j++;
					else
						break;
			}if(Integer.valueOf(s.substring(0,i))!=0)i++;
					else
						break;
		}
		return fin;
    }
}