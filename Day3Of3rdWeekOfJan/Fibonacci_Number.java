package Day3Of3rdWeekOfJan;
public class Fibonacci_Number {
    public int fib(int n) {
        // there are multiple approach for this questions
        if(n == 0) return 0;
        if(n == 1) return 1;

        return fib(n-1) + fib(n-2);
    }
}