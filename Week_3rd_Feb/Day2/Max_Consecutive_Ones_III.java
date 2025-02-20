package Week_3rd_Feb.Day2;

class Max_Consecutive_Ones_III {
    /*
     * Given a binary array nums and an integer k, return the maximum number of consecutive 1's 
     * in the array if you can flip at most k 0's.

        Example 1:

        Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
        Output: 6
        Explanation: [1,1,1,0,0,1,1,1,1,1,1]
        Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
     */
    public int longestOnes(int[] nums, int k) {
        // with the help of hint you can think this qns as window can't have more than k zeros, here you go
        // from this qns will learn that sometime we have see the problem in different way then it become easy.
        // I am very proud of you Vijay, You are really doing progress Great!
        int max = 0, i=0, j=0, zero = 0;
        while(j < nums.length)
        {
            if(nums[j] == 0)
            {
                zero++;
            }

            if(zero > k)
            {
                while(zero > k)
                {
                    if(nums[i] == 0)
                    {
                        zero--;
                    }

                    //if(zero <= k) break;
                    i++;
                }
            }

            max = Math.max(max, j-i+1);
            j++;
        }

        return max;
    }
}