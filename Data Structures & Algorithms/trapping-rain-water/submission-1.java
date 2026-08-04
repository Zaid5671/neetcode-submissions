class Solution {
    public int trap(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        
        int leftMax = 0;
        int rightMax = 0;
        
        int totalWater = 0;

        while (left < right) {
            // We only care about the smaller of the two max heights, 
            // because water is bottlenecked by the shorter side.
            if (nums[left] < nums[right]) {
                if (nums[left] >= leftMax) {
                    leftMax = nums[left]; // Update max, can't trap water here
                } else {
                    totalWater += leftMax - nums[left]; // Trap water
                }
                left++;
            } else {
                if (nums[right] >= rightMax) {
                    rightMax = nums[right]; // Update max, can't trap water here
                } else {
                    totalWater += rightMax - nums[right]; // Trap water
                }
                right--;
            }
        }

        return totalWater;
    }
}