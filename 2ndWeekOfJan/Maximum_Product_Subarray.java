public class Maximum_Product_Subarray {
    /*
     * Given an integer array nums, find a subarray
    that has the largest product, and return the product.
    The test cases are generated so that the answer will fit in a 32-bit integer.
     */
    public int maxProduct(int[] nums) {
        /*
        NOTE: CASES
        1. All positive
        2. even negative
        3. odd negative
        4. what when zero came
        */
        int maxi = Integer.MIN_VALUE;
        int pre = 1, suf = 1;
        int n = nums.length;
        for(int i=0;i<nums.length;i++)
        {
            pre = pre * nums[i];
            suf = suf * nums[n-i-1];

            maxi = Math.max(maxi, Math.max(pre, suf));

            if(pre == 0) pre = 1;
            if(suf == 0) suf = 1;
        }

        return maxi;

        /*
         * // Very good, you have done it in one short but let's optimised it.
         * int max = -11;
         * for(int i=0;i<nums.length;i++)
         * {
         * int mul = 1;
         * for(int j = i;j<nums.length;j++)
         * {
         * mul = mul*nums[j];
         * 
         * if(mul > max)
         * {
         * max = mul;
         * }
         * }
         * }
         * 
         * for(int num : nums)
         * {
         * if(num > max)
         * {
         * max = num;
         * }
         * }
         * 
         * return max;
         */
    }
}