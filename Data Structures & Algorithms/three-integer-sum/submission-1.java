class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0;i<n-1;i++){
            int target = nums[i]*(-1);
            int l = i+1;
            int r = n-1;
            while(l<r){
                if(nums[l]+nums[r]==target){
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                }
                else if(nums[l]+nums[r]>target){
                    r--;
                }else{
                    l++;
                }
            }
            
        }
        return new ArrayList<>(list);
    }

}
