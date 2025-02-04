public class Pow_x_n {
    /*
     * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
     * Constraints:
        -100.0 < x < 100.0
        -231 <= n <= 231-1
        n is an integer.
        Either x is not zero or n > 0.
        -104 <= xn <= 104
     */
    public double myPow(double x, int n) {
        return findPow(x, n);
        /* nice try but put more afforts bro
        boolean isNegativePower = false;
        long p = n;
        if(n < 0)
        {
            p = n*-1;
            isNegativePower = true;
        }

        double result = help(x, p);

        return isNegativePower ? 1/result : result;
        */
    }
    // this is your code, nice try
    @SuppressWarnings("unused")
    private double help(double x, long n)
    {
        if(n  == 1) return x;

        return x*help(x, n-1);
    }

    private double findPow(double x, long n)
    {
        // have a simple thinking don't make too complicated
        if(n == 0) return 1;
        if(n < 0) return findPow(1/x, -n);
        if(n%2 == 0) return findPow(x*x, n/2);
        else return x* findPow(x*x, (n-1)/2);
    }
}