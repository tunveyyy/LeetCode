class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        int ans = 0;
        
        int[] index = new int[128];
        
        for(int i = 0, j = 0; i < n; i++) {
            
            j = Math.max(index[s.charAt(i)], j);
            ans = Math.max(ans, i - j + 1);
            index[s.charAt(i)] = i + 1;
            }
        
        return ans;
        
        }
        
    }