class CountPrimeLessThenN {
    /*
     * Example 1:
     * 
     * Input: n = 10
     * Output: 4
     * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
     */
    public int countPrimes(int n) {
        int count = 0;
        boolean[] primes = new boolean[n + 1];

        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }

        findPrime(primes, n);

        for (int i = 2; i < n; i++) {
            if (primes[i])
                count++;
        }

        return count;
    }

    private void findPrime(boolean[] primes, int n) {
        for (int p = 2; p * p <= n; p++) {
            if (primes[p]) {
                for (int i = p * p; i <= n; i = i + p) {
                    primes[i] = false;
                }
            }
        }
    }
}