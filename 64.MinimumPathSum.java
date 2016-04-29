/* DP */

public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int[][] minSum = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; ++i) {
            Arrays.fill(minSum[i], Integer.MAX_VALUE);
        }
        minSum[0][0] = grid[0][0];
        for(int i = 1; i < grid.length; ++i) {
            minSum[i][0] = minSum[i-1][0] + grid[i][0];
        }
        for(int j = 1; j < grid[0].length; ++j) {
            minSum[0][j] = minSum[0][j-1] + grid[0][j];
        }
        for(int i = 1; i < grid.length; ++i) {
            for(int j = 1; j < grid[0].length; ++j) {
                minSum[i][j] = Math.min(minSum[i-1][j], minSum[i][j-1]) + grid[i][j];
            }
        }
        return minSum[grid.length-1][grid[0].length-1];
    }
}