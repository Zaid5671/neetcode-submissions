class Solution {
    public int maxProfit(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        int min = nums[0];
        int maxProfit = 0;

        for(int i = 1;i<nums.length;i++){
            if(nums[i]<min){
                min = nums[i];
                continue;
            }
            maxProfit = Math.max(maxProfit,nums[i]-min);
        }
        return maxProfit;    
        }
}
