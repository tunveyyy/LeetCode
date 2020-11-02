class Solution {
    public int[][] generateMatrix(int n) {
        
        
        int[][] matrix = new int[n][n];
       
        int i = 1;
        int rStart = 0, rEnd = matrix.length - 1;
        int cStart = 0, cEnd = matrix[0].length - 1;
        
        while(rStart <= rEnd && cStart <= cEnd) {
            
            for(int c = cStart; c <= cEnd; c++) {matrix[rStart][c] = i ; i++;}
            for(int r = rStart + 1; r <= rEnd; r++) {matrix[r][cEnd] = i; i++;}
            if(rStart < rEnd && cStart < cEnd) {
                for(int c = cEnd - 1; c > cStart; c--) {matrix[rEnd][c] = i; i++;}
                for(int r = rEnd; r > rStart; r--) {matrix[r][cStart] = i; i++;}
            }
            rStart++;
            rEnd--;
            cStart++;
            cEnd--;
        }
        return matrix;
    
    }
}