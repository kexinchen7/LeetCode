/*
matrix is like: 
[ [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/
// second solution - use binary search, and index converstion between 1D and 2D array
public class Solution {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if( matrix == null)   return false;
    
        int row = matrix.length;
        int col = matrix[0].length;
        
        if(row == 0 || col == 0) {
            return false;
        }
        
        int start = 0, end = row*col - 1;
        
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            int num = matrix[mid/col][mid%col];
            
            if(num < target) {
                start = mid;
            } else if(num == target) {
                return true;
            } else if(num > target) {
                end = mid;
            }
        }
        
        if(matrix[start/col][start%col] == target) {
            return true;
        }
        
        if(matrix[end/col][end%col] == target) {
            return true;
        
        return false;
    }
}



// first solution I made, it is very tedious
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
            
        int m = matrix.length;
        int n = matrix[0].length;
        
        if(matrix == null || m==0 || n==0)
            return false;
        
        int start = 0, end = m-1;
        int mid;
        int rowI, colI;
        /* be careful how u divide into two halves
         * and the loop exit condition
         */
        /* search the row */
        while(start < end)
        {
            mid = ((end-start)%2 == 0) ? (end+start)/2 : (end+start)/2 + 1;
        
            if(target < matrix[mid][0])
            {
                end = mid-1;
            }
            else
            {
                start = mid;
            }
        }
        
        rowI = start;
        
        start = 0;
        end = n-1;
        /* search the column */
        while(start < end)
        {
            mid = ((end-start)%2 == 0) ? (end+start)/2 : (end+start)/2 + 1;
            
            if(target < matrix[rowI][mid])
            {
                end = mid - 1;
            }
            else
            {
                start = mid;
            }
        }
        
        colI = start;
        
        return (matrix[rowI][colI]==target) ? true : false;
        
    }

}