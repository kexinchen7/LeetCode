/* DP */
public class Solution {
    public int climbStairs(int n) {
        if(n <= 0) {
            return -1;
        }
        if(n == 1) {
            return 1;
        }
        int[] ret = new int[n];
        ret[0] = 1;
        ret[1] = 2;
        for(int i = 2; i < n; ++i) {
            ret[i] = ret[i-1] + ret[i-2];
        }
        return ret[n-1];
    }
}