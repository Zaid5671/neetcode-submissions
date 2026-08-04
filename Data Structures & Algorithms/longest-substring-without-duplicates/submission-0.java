class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l =0;
        int maxLen = 0;

        int[] freq = new int[128];

        for(int r = 0;r<s.length();r++){
            freq[s.charAt(r)]++;
            while(freq[s.charAt(r)]>1){
                freq[s.charAt(l)]--;
                l++;
            }
            maxLen = Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
}
