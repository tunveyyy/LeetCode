class Solution {
    /*
    Greedy Algorithm
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        if(n * k == 0) return new int[0];
        if(k == 1) return nums;
        
        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        
        for(int i = 1; i < n; i++) {
            if(i % k == 0) left[i] = nums[i];
            else left[i] = Math.max(left[i - 1], nums[i]);
            
            int j = n - i - 1;
            if((j + 1) % k == 0) right[j] = nums[j];
            else right[j] = Math.max(right[j + 1], nums[j]);
        }
        
        int[] output = new int[n - k + 1];
        for(int i = 0; i < n - k + 1; i++) {
            output[i] = Math.max(right[i], left[i + k - 1]);
        }
        return output;
    }
}

class Solution {
    /*
    Dynamic Programming Approach
    */
    public int maxSubArray(int[] nums) {
        
        int globalSum = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            
            if(nums[i - 1] > 0) nums[i] += nums[i - 1];
            globalSum = Math.max(nums[i], globalSum);
            
        }
        return globalSum;
    }
}