class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int l = 0;
        int maxLen = 0;
        int maxfreq = 0;

        for(int r = 0;r<s.length();r++){
            freq[s.charAt(r)-'A']++;
            if(freq[s.charAt(r)-'A']>maxfreq){
                maxfreq = freq[s.charAt(r)-'A'];
            }

            if((r-l+1)-maxfreq>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            if((r-l+1)-maxfreq<=k){
                maxLen = Math.max(maxLen,r-l+1);
            }
        }
        return maxLen;
    }
}
