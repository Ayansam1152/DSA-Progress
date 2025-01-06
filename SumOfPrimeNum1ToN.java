class SumOfPrimeNum1ToN {
    /*
     * Input: N = 5
     * Output: 10
     * Explanation: 2, 3, and 5 are prime
     * numbers between 1 and 5(inclusive), and their sum is 2 + 3 + 5 = 10.
     */
    public long prime_Sum(int n) {
        // code here
        long sum = 0;

        for (int i = 2; i <= n; i++) {
            int num = i;
            if (isPrime(num)) {
                sum = sum + num;
            }
        }

        return sum;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}