class Solution {
    public void c(int s,int m,int e,int a[]){
       ArrayList<Integer> aa = new ArrayList<>();
       ArrayList<Integer> b = new ArrayList<>();
       ArrayList<Integer> c = new ArrayList<>();
        for(int i=s;i<=m;i++)
            aa.add(a[i]);
        for(int i=m+1;i<=e;i++)
            b.add(a[i]);
        for(int i=0,j=0,fi=0,fj=0;i+j<aa.size()+b.size();){
            if(i==aa.size())fi=1;
            if(j==b.size())fj=1;
            if(fj==1 ||(fi==0 && aa.get(i)<b.get(j)))
                c.add(aa.get(i++));
            else
                c.add(b.get(j++));
        }
        for(int i=0;i<c.size();i++)
            a[i+s] = c.get(i);  
    }
    public void m(int s,int e,int a[]){
        if(s>=e)
            return;
        int in = (s+e)/2;
        m(s,in,a);
        m(in+1,e,a);
        c(s,in,e,a);

    }
    public int[] sortArray(int[] a) {
        m(0,a.length-1,a);
        return a;
    }
}