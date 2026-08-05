class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        
        // Use an array instead of HashMap. ASCII characters go up to 127.
        int[] map = new int[128];
        
        // Count frequencies of characters in t
        for(int i = 0; i < t.length(); i++){
            map[t.charAt(i)]++;
        }

        int count = t.length(); // Total characters we need to match
        int minLen = Integer.MAX_VALUE;
        int minIdx = 0;
        int l = 0;
        
        for(int r = 0; r < s.length(); r++){
            char rc = s.charAt(r);
            
            // If the character at r is needed, decrement our required count
            if(map[rc] > 0){
                count--;
            }
            // Decrement the map count (it can go negative for characters we don't need or excess characters)
            map[rc]--; 
            
            // When count == 0, we have a valid window
            while(count == 0){
                if(r - l + 1 < minLen){
                    minLen = r - l + 1;
                    minIdx = l;
                }
                
                char lc = s.charAt(l);
                // Put the character at l back into our map
                map[lc]++;
                
                // If map[lc] becomes > 0, it means we just removed a character we actually needed
                if(map[lc] > 0){
                    count++;
                }
                l++;
            }
        }
        
        if(minLen == Integer.MAX_VALUE) return "";
        return s.substring(minIdx, minIdx + minLen);
    }
}