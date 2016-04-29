/* DP */
public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        int n = A.length;
        if (A == null || n == 0) {
            return -1;
        }
        int[] state = new int[n];
        Arrays.fill(state, Integer.MAX_VALUE);
        state[0] = 0;
        for(int i = 1; i < n; ++i) {
            for(int j = 0; j < i; ++j) {
                if(state[j] != Integer.MAX_VALUE && A[j] + j >= i) {
                    state[i] = Math.min(state[i], state[j] + 1);
                }
            }
        }
        return state[n-1];
    }
}

/* Greedy */
/* we calculate how far we can reach if jump k times */
public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        int n = A.length;
        if (A == null || n == 0) {
            return -1;
        }
        int curMax = 0, njumps = 0, i = 0;
        while(curMax < n - 1) {
            int lastMax = curMax;
            for( ; i <= lastMax; ++i) {
                curMax = Math.max(curMax, i + A[i]);
            }
            njumps++;
            if(lastMax == curMax) return -1;
        }
        return njumps;
    }
}







