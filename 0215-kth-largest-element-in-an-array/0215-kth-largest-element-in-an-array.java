class Solution {
    public int findKthLargest(int[] a, int k) {
        Arrays.sort(a);
        return a[a.length-k];
    }
}