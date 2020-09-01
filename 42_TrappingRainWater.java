class Solution {
    public int trap(int[] height) {
        
        if(height == null || height.length == 0)
            return 0;
        int ans = 0;
        
        int[] lm = new int[height.length];
        int[] rm = new int[height.length];
        int res = 0;
        
        lm[0] = height[0];
        rm[height.length - 1] = height[height.length - 1];
        
        for(int i = 1; i < lm.length; i++) {
            
            lm[i] = Math.max(height[i], lm[i - 1]);
        }
        
        for(int i = height.length - 2; i >= 0; i--) {
            rm[i] = Math.max(height[i], rm[i+1]);
            
        }
        for(int i = 0; i < lm.length; i++) {
            
            res += Math.min(lm[i],rm[i]) - height[i];
        }
        
        return res;
        
    }
}