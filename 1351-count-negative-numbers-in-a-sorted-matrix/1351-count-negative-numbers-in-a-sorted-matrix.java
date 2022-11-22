class Solution {
    public int countNegatives(int[][] a) {
        int r = a.length;
        int c = a[0].length;
        int count=0;
        for(int i=0;i<r;i++)
            for(int j=c-1;j>=0;j--){
               if(a[i][j]<0)
                  count ++;
                else
                    break;
                }
        return count;
    }
}