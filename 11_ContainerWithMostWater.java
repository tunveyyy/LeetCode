// Two pointer based solution

class Solution {
    public int maxArea(int[] height) {
        
        int area = 0, left = 0, right = height.length - 1;
        
        while(left < right) {
            int currentArea =  Math.min(height[left], height[right]) * (right - left);
            area = Math.max(area, currentArea);
            if(height[left] < height[right])
                left++;
            else
                right--;
                
        }
        return area;
    }
}