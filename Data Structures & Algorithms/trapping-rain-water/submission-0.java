class Solution {
    public int trap(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        int pMax = nums[0];
        prefix[0] = 0;
        suffix[n-1] = 0;
        for(int i = 1;i<n;i++){
            if(nums[i]>pMax){
                prefix[i]=pMax;
                pMax = nums[i];
            }else{
                prefix[i]=pMax;
            }
        }
        int sMax = nums[n-1];
        for(int i = n-2;i>=0;i--){
            if(nums[i]>sMax){
                suffix[i] = sMax;
                sMax = nums[i];
            }else{
                suffix[i] = sMax;
            }
        }
        int maxA = 0;
        for(int i = 0;i<n;i++){
            int toAdd = Math.min(prefix[i],suffix[i])-nums[i];
            System.out.print(toAdd+" ");
            if(toAdd<0){
                continue;
            }
            maxA += toAdd;
        }

        return maxA;
    }
}
