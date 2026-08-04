class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1>n2){
            return false;
        }
        int[] req = new int[28];

        for(int i =0;i<n1;i++){
            req[s1.charAt(i)-'a']++;
            req[s2.charAt(i)-'a']--;
        }
        if(matches(req))return true;
        
        int l = 0;
        for(int r = n1;r<n2;r++){
            req[s2.charAt(l)-'a']++;
            req[s2.charAt(r)-'a']--;
            l++;

            //check if valid subsequence
            boolean isValid = matches(req);
            if(isValid){
                return true;
            }
        }
        return false;
    }
    private boolean matches(int[] req) {
        for (int freq : req) {
            if (freq > 0) {
                return false;
            }
        }
        return true;
    }
}
