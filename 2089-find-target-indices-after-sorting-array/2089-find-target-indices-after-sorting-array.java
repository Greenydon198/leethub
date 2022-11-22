class Solution {
    public List<Integer> targetIndices(int[] a, int k) {
        ArrayList<Integer> aa = new ArrayList<>();
        Arrays.sort(a);
        for(int i=0;i<a.length;i++)
            if(a[i]==k)
                aa.add(i);
        return aa;
    }
}