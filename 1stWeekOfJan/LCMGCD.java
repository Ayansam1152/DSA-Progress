class Solution {
    /*
     * Input: a = 5 , b = 10
     * Output: [10, 5]
     * Explanation: LCM of 5 and 10 is 10, while their GCD is 5.
     */
    public static int[] lcmAndGcd(int a, int b) {
        // code here
        int gcd = 0;

        for (int i = Math.min(a, b); i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
                break;
            }
        }

        int lcm = (a * b) / gcd;

        return new int[] { lcm, gcd };
    }
}