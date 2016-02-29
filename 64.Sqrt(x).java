

// the main idea behind the binary search solutions: find the largest position that <= sqrt(target)
public class Solution {
    public int mySqrt(int x) {
        if(x <= 0) {
            return 0;
        }
        // upgrade to long preventing the overflow when multiply mid by mid
        long start = 1, end = (long) x;
        
        while(start + 1 < end) {
            long mid = start + (end - start)/2;
            if(mid*mid < x) {
                start = mid;
            } else if(mid*mid == x) {
                return (int)mid;
            } else if(mid*mid > x) {
                end = mid;
            }
        }
        
        if(end*end < x) {
            return (int)end;
        }
        return (int)start;
    }
}

// or you can write it as like template given by NineChapter
public class Solution {
    public int mySqrt(int x) {
        if(x <= 0) {
            return 0;
        }
        
        long start = 1, end = (long) x;
        
        while(start + 1 < end) {
            long mid = start + (end - start)/2;
            if(mid*mid < x) {
                start = mid;
            } else if(mid*mid == x) {
                start = mid;
            } else if(mid*mid > x) {
                end = mid;
            }
        }
        
        if(end*end <= x) {
            return (int)end;
        }
        return (int)start;
    }
}


// binary search solution for obtaining double precision results

/*
why we return "(int) end" not "(int) start" ?
 - because type-casting would lose some precision

The program does not apply for a target number which is between 0 and 1
 - because the real result is larger than target number, and the division by would decrease the value
*/

public class Solution {
    public int mySqrt(int x) {
        if(x <= 0) {
            return 0;
        }
        double xx = (double) x; // double version of x
        double start = 0, end = xx;
        
        while((end - start) > 1e-6) {
            double mid = start + (end - start)/2;
            
            if(mid*mid == xx) {
                start = mid;
            } else if(mid*mid > xx) {
                end = mid;
            } else if(mid*mid < xx) {
                start = mid;
            }
        }
        System.out.println("the end is: "+ end);
        System.out.println("the start is: "+ start);
        
        return (int)end;
    }
}


// the newton solution is better for obtaining double precision results
// and both ok for target value between [0,1] and [1, ..]
public class Solution {
    public int mySqrt(int x) {
        
        if(x<=0) return 0;
        
        double epsilon = 1e-15;
        double t = x;
        
        while(Math.abs(t-x/t) > epsilon*t)
        {
            t = (x/t + t) / 2.0;
        }
        
        return (int)t;
    }
}

