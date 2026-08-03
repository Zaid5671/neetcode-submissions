class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // OPTIMIZATION 1: Skip duplicate values for 'i'
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1;
            int r = n - 1;

            while (l < r) {
                // Use a single sum calculation (avoids overflow risk with long if needed, though int is fine for standard constraints)
                int sum = nums[i] + nums[l] + nums[r];

                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    
                    // Move both pointers after finding a match
                    l++;
                    r--;

                    // OPTIMIZATION 2: Skip duplicate values for 'l'
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    
                    // Note: You do not need a while loop to skip duplicates for 'r' 
                    // because fixing 'i' and a unique 'l' forces 'r' to naturally 
                    // fail the sum condition in the next loop and decrement anyway.
                }
            }
        }
        
        return res;
    }
}