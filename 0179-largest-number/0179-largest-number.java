class Solution {
    public String largestNumber(int[] nums) {
        String s[]=new String[nums.length];
        for(int i=0;i<nums.length;i++)
            s[i] = String.valueOf(nums[i]);
        Arrays.sort(s,(x,y)->(y+x).compareTo(x+y));
        String ss = "";
        for(int i=0;i<s.length;i++)
            ss+=s[i];
        return (ss.charAt(0)=='0')?"0":ss;
    }
}