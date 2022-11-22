class Solution {
    public List<List<Integer>> subsets(int[] a) {
        List<List<Integer>> s = sub(a,a.length-1);
        // Collections.sort(s,(x,y)->((x.get(0)-y.get(0))));
        return s;
    }
    public List<List<Integer>> sub(int a[],int i){
        if(i==-1){
            List<List<Integer>> t = new ArrayList<List<Integer>>();
            // ArrayList<Integer> tt = 
            // tt.add(a[i]);
            t.add(new ArrayList<Integer>());
            return t;
        }
        List<List<Integer>> s = sub(a,i-1);
        for(int in=s.size()-1;in>=0;in--){
        List<Integer> temp = new ArrayList<Integer>();
            for(int j=0;j<s.get(in).size();j++)
                temp.add(s.get(in).get(j));
            temp.add(a[i]);
            
        s.add(temp);
        }
        return s;
    }
}