class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> ans = new ArrayList<>();
        if(matrix.length == 0)
            return ans;
        
        int rStart = 0, rEnd = matrix.length - 1;
        int cStart = 0, cEnd = matrix[0].length - 1;
        
        while(rStart <= rEnd && cStart <= cEnd) {
            
            for(int c = cStart; c <= cEnd; c++) ans.add(matrix[rStart][c]);
            for(int r = rStart + 1; r <= rEnd; r++) ans.add(matrix[r][cEnd]);
            if(rStart < rEnd && cStart < cEnd) {
                for(int c = cEnd - 1; c > cStart; c--) ans.add(matrix[rEnd][c]);
                for(int r = rEnd; r > rStart; r--) ans.add(matrix[r][cStart]);
            }
            rStart++;
            rEnd--;
            cStart++;
            cEnd--;
        }
        return ans;
    }
}