class Solution {
    public void sortColors(int[] a) {
        for(int i=0;i<a.length;i++){
            int m=3,t=-1;
            for(int j=i;j<a.length;j++)
                if(a[j]<m){
                    m=a[j];
                    t=j;
                }
            if(t!=-1){
                a[t]=a[i];
                a[i]=m;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}