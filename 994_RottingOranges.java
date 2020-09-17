class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        
        int freshOranges = 0; 
        int ROWS = grid.length, COLS = grid[0].length;
        
        for(int r = 0; r < ROWS; r ++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == 2) 
                    queue.add(new Pair(r,c));
                if(grid[r][c] == 1)
                    freshOranges++;
            } 
        }
        queue.add(new Pair(-1,-1));
        int time = -1;
        int[][] directions = {{-1,0}, {1,0}, {0,1}, {0,-1}};
        
        while(!queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.poll();
            int row = p.getKey();
            int col = p.getValue();
            
            if(row == -1) {
                time++;
                if(!queue.isEmpty())
                    queue.add(new Pair(-1,-1));

            }
            else {
                for(int[] d: directions) {
                    int nextRow = row + d[0];
                    int nextCol = col + d[1];
                    
                    if(nextRow >= 0 && nextRow < ROWS && nextCol >= 0 && nextCol < COLS) {
                        if(grid[nextRow][nextCol] == 1) {
                            grid[nextRow][nextCol] = 2;
                            freshOranges--;
                            queue.add(new Pair(nextRow, nextCol));
                        }
                    }
                } 
            }
        }

        return freshOranges == 0 ? time : -1;
    }
}