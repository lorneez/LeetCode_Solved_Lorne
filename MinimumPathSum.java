class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int width = grid[0].length;
        int height = grid.length;
        for(int i=1; i<width; i++){
            grid[0][i] += grid[0][i-1];
        }
        for(int i=1; i<height; i++){
            grid[i][0] += grid[i-1][0];
            for(int j=1; j<width; j++){
                if(grid[i-1][j] > grid[i][j-1]){
                    grid[i][j] += grid[i][j-1];
                }
                else{
                    grid[i][j] += grid[i-1][j];
                }
            }
        }
        return grid[height-1][width-1];
    }
}