package Day3Of3rdWeekOfJan;

public class Power_of_Two {
    public boolean isPowerOfTwo(int n) {
        // this edge case I forgot due to hurry, so please make sure there is not hurry while solving problems
        if(n <= 0) return false;
        return (n & (n-1)) == 0;
    }

    @SuppressWarnings("unused")
    private boolean recursion(int n)
    {   
       return n > 0 && (n == 1 || (n%2 == 0 && recursion(n/2)));

    }
@SuppressWarnings("unused")
    
    private boolean loop(int n)
    {
        if( n < 0) return false;

        while(n%2 == 0)
        {
            n = n/2;
        }

        return n == 1;
    }
}