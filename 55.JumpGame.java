  
/* greedy */
/* keep the maximum index we can reach */
public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        int n = A.length;
        if (A == null || n == 0) {
            return false; // exception
        }
        int maxIdx = A[0];
        for (int i = 1; i < n; ++i) {
            if (maxIdx < i || maxIdx > n - 1) {
                break;
            }
            maxIdx = Math.max(maxIdx, A[i] + i);
        }
        return (maxIdx >= n - 1);
    }
}

/* DP */
public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        int n = A.length;
        if (A == null || n == 0) {
            return false; // exception
        }
        boolean[] state = new boolean[n];
        Arrays.fill(state, false);
        state[0] = true;
        for (int i = 1; i < n; ++i) {
            for(int j = 0; j < i; ++j) {
                if(state[j] && A[j] >= (i-j)) {
                    state[i] = true;
                    break;
                }   
            }
        }
        return state[n-1];
    }
}

