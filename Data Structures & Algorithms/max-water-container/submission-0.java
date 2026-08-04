class Solution {
    public int maxArea(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int maxA = Math.min(nums[r],nums[l])*(r-l);

        while(l<r){
            if(nums[l]<nums[r]){
                l++;
            }else{
                r--;
            }
            maxA = Math.max(maxA,Math.min(nums[r],nums[l])*(r-l));
        }
        return maxA;
    }
}
