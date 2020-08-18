class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> output = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            
            if(i == 0 || nums[i - 1] != nums[i])
                twoSum(nums, i, output);
        }
        return output;
    }
    public void twoSum(int[] nums,int i, List<List<Integer>> output){
        int lo = i + 1, high = nums.length - 1;
        
        while(lo < high) {
            int sum = nums[i] + nums[lo] + nums[high];
            if(sum < 0) lo++;
            else if (sum > 0) high--;
            else {
                output.add(Arrays.asList(nums[i], nums[lo++], nums[high--]));
                while(lo < high && nums[lo] == nums[lo - 1]) 
                    lo++;
            }
        }
    }
}