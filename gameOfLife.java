// This code is written from optimised version of Game of life without using extra space for the output matrix

// Time Complexity is O(N*M) where N and M are dimesions of the matrix
// Space Complexity is O(1)
// https://www.geeksforgeeks.org/program-for-conways-game-of-life-set-2/?ref=rp 

class gameOfLife {
  public static void main(String[] args) {
    int[][] grid = {
      { 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0 }, 
      { 0, 0, 0, 1, 1, 0, 
        0, 0, 0, 0 }, 
      { 0, 0, 0, 0, 1, 0, 
        0, 0, 0, 0 }, 
      { 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0 }, 
      { 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0 } 
      }; 
      NextGeneration(grid);
      print(grid);
  }

  private static boolean save(int[][]grid, int row, int col) {
    return(grid.length > row && grid[0].length > col && row >= 0 && col>= 0);
  }
  private static void NextGeneration(int[][] grid) {
    int cols = grid[0].length;
    int rows = grid.length;

    int[] r = {1,-1,0,0,1,-1,-1,1};
    int[] c = {0,0,1,-1,1,1,-1,-1};
    for(int i = 0; i < rows; i++) {
      for(int j = 0; j < cols; j++) {

        if(grid[i][j] > 0) {

          for(int k = 0; k < 8; k++) {
              if(save(grid, i+r[k],j+c[k]) && grid[i+r[k]][j+c[k]] > 0) {
                grid[i][j]++;
              }
          }
        }
        else {
            for(int k = 0; k < 8; k++) {
              if(save(grid, i+r[k],j+c[k]) && grid[i+r[k]][j+c[k]] > 0) {
                grid[i][j]--;
            }
          }
        }
      }
    }
    for(int i = 0; i < rows; i++) {
      for(int j = 0; j < cols; j++) {
        // if intial value was 1
        if(grid[i][j] > 0) {

            // SInce anything with less than 2 live dies
          if(grid[i][j] < 3) {
            grid[i][j] = 0;
          }

          else if(grid[i][j] <= 4)
            grid[i][j] = 1;

          else if(grid[i][j] > 4)
            grid[i][j] = 0;

        }
        else {
          if(grid[i][j] == -3)
            grid[i][j] = 1;
          else 
            grid[i][j] = 0;
        }
      }
    }
  }

  private static void print(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;

    for(int i = 0; i < rows; i++) {
      for(int j = 0; j < cols; j++) {
        System.out.print(grid[i][j]);
      }
      System.out.println();
    }
  }
}
