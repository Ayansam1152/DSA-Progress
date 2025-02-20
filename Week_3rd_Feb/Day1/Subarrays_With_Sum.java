package Week_3rd_Feb.Day1;

import java.util.HashMap;
import java.util.Map;

class Binary_Subarrays_With_Sum {
    /*
     * Given a binary array nums and an integer goal, return the number of non-empty 
     * subarrays with a sum goal. A subarray is a contiguous part of the array.

    Example 1:

    Input: nums = [1,0,1,0,1], goal = 2
    Output: 4
    Explanation: The 4 subarrays are bolded and underlined below:
    [1,0,1,0,1]
    [1,0,1,0,1]
    [1,0,1,0,1]
    [1,0,1,0,1]
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        // this is also the same template keep practicing bro
        // store the cumulative sum in map and if find then add count of it
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int cumulativeSum = 0;
        int count = 0;

        int i=0;
        while(i < nums.length)
        {
            cumulativeSum += nums[i];

            if(map.containsKey(cumulativeSum-goal))
            {
                count += map.get(cumulativeSum-goal);
            }
           
                map.put(cumulativeSum, map.getOrDefault(cumulativeSum,0)+1);
            
            i++;
        }

        return count;
    }
}