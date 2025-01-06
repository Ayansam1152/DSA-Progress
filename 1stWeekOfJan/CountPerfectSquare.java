class CountPerfectSquare {
    /*
     * Consider a sample space consisting of all perfect squares starting from 1, 4,
     * 9 and so on.
     * You are given a number n, you have to find the number of integers less than n
     * in the sample space.
     */
    static int countSquares(int n) {
        // code here

        int count = 0;
        for (int i = 1; i < Math.sqrt(n); i++) {
            if (i * i <= n)
                count++;
            else
                break;
        }

        return count;
    }
}