/* DFS: Divide Conquer + Memorization */
public class Solution {
    private int n;
    private int[][] minSum;
    private List<List<Integer>> triangle;
    
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) {
            return -1;
        }
        if(triangle.get(0) == null || triangle.get(0).size() == 0) {
            return -1;
        }
        this.n = triangle.size();
        this.triangle = triangle;
        this.minSum = new int[n][n];
        
        for(int i = 0; i < n; ++i) {
            Arrays.fill(minSum[i], Integer.MAX_VALUE);
        }
        return search(0, 0);
    }
    
    public int search(int x, int y) {
        if(x == n) {
            return 0;
        }
        if(minSum[x][y] != Integer.MAX_VALUE) {
          return minSum[x][y];  
        }
        
        minSum[x][y] = triangle.get(x).get(y) + Math.min(search(x + 1, y), search(x + 1, y + 1));
        return minSum[x][y];
    }
}


/* DP: top-down */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) {
            return -1;
        }
        if(triangle.get(0) == null || triangle.get(0).size() == 0) {
            return -1;
        }
        int n = triangle.size();
        int ret = Integer.MAX_VALUE;
        int[][] minSum = new int[n][n];
        for(int i = 0; i < n; ++i) {
            Arrays.fill(minSum[i], 0);
        }
        /* top-down initialize */
        minSum[0][0] = triangle.get(0).get(0);
        /* leftmost and rightmost */
        for(int i = 1; i < n; ++i) {
            minSum[i][0] = minSum[i-1][0] + triangle.get(i).get(0);
            minSum[i][i] = minSum[i-1][i-1] + triangle.get(i).get(i);
        }
        /* calculate nodes in the middle */
        for(int i = 1; i < n; ++i) {
            for(int j = 1; j < i; ++j) {
                minSum[i][j] = triangle.get(i).get(j) + Math.min(minSum[i-1][j-1], minSum[i-1][j]);
            }
        }
        for(int j = 0; j < n; ++j) {
            if(minSum[n-1][j] < ret) {
                ret = minSum[n-1][j];
            }
        }
        return ret;
    }
}