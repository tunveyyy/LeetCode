class Solution {
    public int numIslands(char[][] grid) {
     
        if(grid == null || grid.length == 0)
            return 0;
        
        int numberOfIslands = 0;
        
        for(int i = 0; i < grid.length; i++) { // number of columns
            for(int j = 0; j < grid[i].length; j++) { // number of rows
                
                if(grid[i][j] == '1') {
                    numberOfIslands += dfs(grid, i, j);
                }
            }
        }
        return numberOfIslands;
    }
    
    public int dfs(char[][] grid, int i, int j ) {
        
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') 
            return 0;
        
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        return 1;
    }
}