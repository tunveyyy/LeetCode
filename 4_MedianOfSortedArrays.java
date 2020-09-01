//O(n) solution by traversing through array

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] numbs_comb = new int[nums1.length + nums2.length];
        
        int idx_1 = 0;
        int idx_2 = 0;
        
        //build sorted combined list
        for(int x = 0; x < numbs_comb.length; x++) {
            if(idx_2 >= nums2.length || idx_1 < nums1.length && 
               nums1[idx_1] <= nums2[idx_2]) {
                numbs_comb[x] = nums1[idx_1];
                idx_1++;
            } else {
                numbs_comb[x] = nums2[idx_2];
                idx_2++;
            }
        }
        
        
        if((nums1.length + nums2.length) % 2 == 0) {
            //even size
            int mid_1 = (numbs_comb.length - 1)/2;
            int mid_2 = mid_1 + 1;
            double res = (double)(numbs_comb[mid_1]) + (double)(numbs_comb[mid_2]);
            return res / 2;
                
            
        } else {
            //odd size
            int mid = numbs_comb.length/2;
            return (double)numbs_comb[mid];
        }
                
    }
}


/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Solution
 * Take minimum size of two array. Possible number of partitions are from 0 to m in m size array.
 * Try every cut in binary search way. When you cut first array at i then you cut second array at (m + n + 1)/2 - i
 * Now try to find the i where a[i-1] <= b[j] and b[j-1] <= a[i]. So this i is partition around which lies the median.
 *
 * Time complexity is O(log(min(x,y))
 * Space complexity is O(1)
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation/4
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        
        
        int x = nums1.length;
        int y = nums2.length;
    
    
        int low = 0;
        int high = x;
    
        while(low <= high) {
            
            int partX = (low + high)/2;
            int partY = (x + y + 1)/2 - partX;
            
            int maxLeftX = (partX == 0) ? Integer.MIN_VALUE: nums1[partX - 1];
            int minRightX = (partX == x) ? Integer.MAX_VALUE: nums1[partX];
            
            int maxLeftY = (partY == 0) ? Integer.MIN_VALUE: nums2[partY - 1];
            int minRightY = (partY == y) ? Integer.MAX_VALUE: nums2[partY];
            
            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if((x + y) % 2 == 0) 
                    return((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                else 
                    return (double)Math.max(maxLeftX, maxLeftY);
            }
            else if(maxLeftX > minRightY) high = partX - 1;
            else low = partX + 1; 
        }
        return 0;
    }
}
