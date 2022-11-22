class Solution {
    public int[] relativeSortArray(int[] aa, int[] a1) {
        int n1 = a1.length;
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i=0;i<aa.length;i++)
            a.add(aa[i]);
        // Collections.addAll(a,aa);
        Collections.sort(a);
        int t=0;
        for(int i=0;i<n1;i++)
            for(int j=0;j<a.size();){
                if(a1[i]==a.get(j)){
                    aa[t++]=a.get(j);
                    a.remove(j);
                    continue;
                }
                j++;
            }
        for(int i=0;i<a.size();i++)
            aa[t++]=a.get(i);
        return aa;
    }
}