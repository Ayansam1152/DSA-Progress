package Week_3rd_Feb.Day1;

import java.util.HashMap;
import java.util.Map;

class Count_Number_of_Nice_Subarrays {
    /*
     * Given an array of integers nums and an integer k. A continuous subarray is called nice 
     * if there are k odd numbers on it.
        Return the number of nice sub-arrays.
    
        Example 1:
        Input: nums = [1,1,2,1,1], k = 3
        Output: 2
        Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
     */
    public int numberOfSubarraysPass(int[] nums, int k) {
        // Finally you have done it bro, I am very proud of myself.
        // this is the default template for solving sliding window using sum method
        int oddCount = 0, count =0,i=0;
        Map<Integer,Integer> map = new HashMap();
        map.put(0,1);

        while(i < nums.length)
        {
            oddCount += nums[i]%2 == 1? 1:0;

            if(map.containsKey(oddCount-k))
            {
                count+= map.get(oddCount-k);
            }

            map.put(oddCount, map.getOrDefault(oddCount,0)+1);
            i++;
        }

        return count;
    }
    public int numberOfSubarraysFail(int[] nums, int k) {
        // Nice try but fail again edge cases
        int oddCount =0, i=0, j = 0;
        int niceSubArrays = 0;

        while(j < nums.length)
        {
            if(nums[j]%2 == 1)
            {
                oddCount++;
            }

            if(oddCount > k)
            {
                while(oddCount > k)
                {
                    if(nums[i]%2 == 1)
                    {
                        oddCount--;
                    }
                    i++;
                }
            }

            if(oddCount == k)
            {
                niceSubArrays++;
            }

            j++;
        }

        while(i < nums.length)
        {
            if(nums[i]%2 == 0)
            {
                niceSubArrays++;
            }
            else
            {
                break;
            }

            i++;
        }

        return niceSubArrays;
    }

    public int numberOfSubarraysWithTLE(int[] nums, int k) {
        // keep it simple generate all subarray
        // great you are doing good progress.
        int result = 0;
        for(int i=0;i<nums.length;i++)
        {
            int oddCount = 0;
            for(int j = i;j<nums.length;j++)
            {
                if(nums[j]%2 == 1)
                {
                    oddCount++;
                }

                if(oddCount == k)
                {
                    result++;
                }

                if(oddCount > k)
                {
                    break;
                }
            }
        }

        return result;
    }
}