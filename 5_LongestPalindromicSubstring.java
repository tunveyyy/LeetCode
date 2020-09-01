class Solution {
    public String longestPalindrome(String s) {
        
        if(s == null || s.length() == 0) return "";
        
        int len  = s.length();
        String maxLength = s.charAt(len - 1) + "";
        
        int[][] table = new int[len][len];
        
        //fill in the base cases
        for(int i = 0; i < len ; i++) {
            table[i][i] = 1;
        }
        
        for(int col = 1; col < len; col++) {
            for(int row = 0; row < col; row++) {
                
                String res = s.substring(row, col + 1);
                
                if(row == col - 1 && s.charAt(col) == s.charAt(row)) {
                    table[row][col] = 1;
                    if(maxLength.length() < res.length()) maxLength = res;
                    
                }
                else {
                    if(table[row + 1][col - 1] == 1 && s.charAt(col) == s.charAt(row)) {
                        table[row][col] = 1;
                        if(maxLength.length() < res.length()) maxLength = res;               
                    }
                }
            }
        }
        return maxLength;        
    }
}