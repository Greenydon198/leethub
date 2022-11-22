class Solution {
    public int maxArea(int[] a) {
        int e = a.length-1;
        int f = 0;
        int p=0;
        while(f<e){
            int t = (e-f)*Math.min(a[f],a[e]);
            p=(t>p)?t:p;
            // if(a[f]>= a[f+1] && a[e]>=a[e-1])
            //     break;
            if(a[f]<a[e])
                f++;
            else
                e--;
        }
        // for(int i=0;i<l;i++){
        // for(int j=i+1;j<l;j++){
        //     int t=Math.min(a[i],a[j])*(j-i);
        //     p=(t>p)?t:p;
        // }
        // }
        return p;
    }
}