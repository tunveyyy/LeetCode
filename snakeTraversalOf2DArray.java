class Main {
  public static void main(String[] args) {
    int[][] mat= { {1, 2, 3, 4},
                   {8, 7, 6, 5},
                   {9, 10, 11, 12},
                   {16, 15, 14, 13},
                   {17, 18, 19, 20}};
    snakeTraverse(mat);          
  }
  public static void snakeTraverse(int[][] grid) {
    boolean reverse = false;
    int rows  =  grid.length;
    int cols = grid[0].length;
    for(int i = 0; i < rows; i++){

      if(!reverse) {
        for(int j = 0; j < cols; j++) {
          System.out.print(grid[i][j] + " ");
        }
        reverse = true;
      }
      else{
        for(int j = cols -1; j >= 0; j--) {
          System.out.print(grid[i][j] + " ");
        }
        reverse = false;
      }
    }
  }
}
