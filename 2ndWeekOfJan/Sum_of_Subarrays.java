public class Sum_of_Subarrays {

    /*
     * Given an array arr. Find the sum of all subarrays of the array since 
     * the sum could be very large print the sum modulo (109+7).
     */

     /*
      * NOTE: O(N) Approach
      1. count the frequency of nums[i] from where subarray started
      2. then count the remaining occurence of the nums[i] in all subarray (substract the count from step1).
      3. try to derive the formula for both step 1 and 2 and then validate. All the Best.
      */
    public long subarraySum(int[] arr) {
        // code here
        long MOD = 1000000007;
        long sum = 0l;
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            // it is faiing casue num could be in 10^9 we need to use mod here also.
            sum = sum % MOD + ((arr[i] % MOD) * ((i + 1) % MOD) * ((n - i) % MOD)) % MOD;
        }

        return sum % MOD;

        /*
         * this code is fine but it is not optimise.
         * long sum = 0l;
         * long MOD = 1000000007;
         * for(int i=0;i<arr.length;i++)
         * {
         * sum = sum%MOD+arr[i]%MOD;
         * for(int j=i;j< arr.length;j++)
         * {
         * sum = sum%MOD+arr[j]%MOD;
         * }
         * }
         * 
         * return sum%MOD;
         */
    }
}
