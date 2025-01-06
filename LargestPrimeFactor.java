class LargestPrimeFactor {
    /*
     * Input: n = 24
     * Output: 3
     * Explanation: The prime factorization of 24 is 23×3.
     * Among the prime factors (2, 3), the largest is 3.
     */
    static int largestPrimeFactor(int n) {
        // code here
        int ans = -1;
        for (int i = 2; i <= n;) {
            if (n % i == 0) {
                ans = i;
                n = n / i;
            } else {
                i++;
            }
        }

        return ans;
    }

    public static void findPrimes(boolean[] primes, int n) {
        for (int p = 2; p * p <= n; p++) {
            if (primes[p]) {
                for (int i = p * p; i <= n; i = i + p) {
                    primes[i] = false;
                }
            }
        }
    }
}