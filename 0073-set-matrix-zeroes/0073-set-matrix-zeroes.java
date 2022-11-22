class Solution {
    public void setZeroes(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int n1[] = new int[n];
        int m1[] = new int[m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(a[i][j]==0){
                    n1[i]=1;
                    m1[j]=1;
                }
        for(int i=0;i<n;i++){
            for(int j=0;j<m && n1[i]==1;j++)
                a[i][j]=0;
        }
        for(int j=0;j<m;j++){
            for(int i=0;i<n && m1[j]==1;i++)
                a[i][j]=0;
        }
        System.out.println(Arrays.toString(a));
    }
}