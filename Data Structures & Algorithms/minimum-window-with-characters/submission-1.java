class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())return "";
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i =0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }

        int have = 0;
        int need = map.size();
        int minLen = Integer.MAX_VALUE;
        int minIdx = 0;
        int l = 0;
        for(int r = 0;r<s.length();r++){
            if(map.containsKey(s.charAt(r))){
                map.put(s.charAt(r),map.get(s.charAt(r))-1);
                if(map.get(s.charAt(r))==0){
                    have++;
                }
            }
            while(have==need){
                if(minLen>(r-l+1)){
                    minLen = r-l+1;
                    minIdx = l;
                }
                if(map.containsKey(s.charAt(l))){
                    map.put(s.charAt(l),map.get(s.charAt(l))+1);
                    if(map.get(s.charAt(l))>0){
                        have--;
                    }
                }
                l++;
            }
        }
        if(minLen == Integer.MAX_VALUE)return "";

        return s.substring(minIdx,minIdx+minLen);
    }
}
