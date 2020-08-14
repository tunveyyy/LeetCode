class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int n2End = n - 1 ,  lastPointer = nums1.length - 1, n1End = m - 1;
        
        while(n2End >= 0 && n1End >= 0) {
            
            if(nums1[n1End] > nums2[n2End]){
                nums1[lastPointer] = nums1[n1End];
                n1End--;
            
            }else {
                nums1[lastPointer] = nums2[n2End];
                n2End --;
            }
            lastPointer--;
        }
        for(int i = lastPointer; i >= 0; i--){
            
            if(n1End < n2End) {
                nums1[i] = nums2[n2End];
                n2End--;
            }
            
        }
    }
}