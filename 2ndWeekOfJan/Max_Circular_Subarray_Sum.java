class Max_Circular_Subarray_Sum {

    /*
     * Given an array of integers arr[] in a circular fashion. 
     * Find the maximum subarray sum that we can get if we assume the array to be circular.
     * Input: arr[] = [10, -3, -4, 7, 6, 5, -4, -1]
        Output: 23
        Explanation: Maximum sum of the circular subarray is 23. The subarray is [7, 6, 5, -4, -1, 10].
     */
    public int circularSubarraySum(int arr[]) {
        /*
         * LOGIC is simple
         * 1. find maxSum using kadan's algo
         * 2. calculate totalSum
         * 3. calculate minSum using kadan's algo
         * return max of maxSum and totalSum-kadan's algo.
         */
        // Your code here
        int totalSum = 0;
        for (int num : arr) {
            totalSum = totalSum + num;
        }

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int num : arr) {
            currSum += num;

            if (currSum > maxSum) {
                maxSum = currSum;
            }

            if (currSum < 0) {
                currSum = 0;
            }
        }

        int minSum = Integer.MAX_VALUE;
        int currMin = 0;

        for (int num : arr) {
            currMin += num;

            if (currMin < minSum) {
                minSum = currMin;
            }

            if (currMin > 0) {
                currMin = 0;
            }
        }

        return Math.max(maxSum, totalSum - minSum);

    }
}
