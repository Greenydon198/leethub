class Solution {
    public int[] twoSum(int[] a, int k) {
        int n = a.length;
        int b[][] = new int[n][2];
        for(int i=0;i<n;i++){
            b[i][0]=a[i];
            b[i][1]=i;
        }
        Arrays.sort(b,(x,y)->(x[0]>=y[0])?1:-1);
        for(int i=0;i<n;i++)
        System.out.println(b[i][0]+" "+b[i][1]);
        int s=0,e=n-1;
        while(s<e){
            if(b[s][0]+b[e][0]==k)
                return new int[]{b[s][1],b[e][1]};
            else if(b[s][0]+b[e][0]>k)
                e--;
            else
                s++;
        }
        return new int[]{1,2};
    }
}