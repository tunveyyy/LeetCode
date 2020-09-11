class Solution {
    public int maxSubArray(int[] nums) {
        
        int globalSum = nums[0], localSum = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            
            localSum = Math.max(nums[i] + localSum, nums[i]);
            globalSum = Math.max(localSum, globalSum);
        }
        return globalSum;
    }
}x