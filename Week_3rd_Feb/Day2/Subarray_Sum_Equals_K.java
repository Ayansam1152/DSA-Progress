package Week_3rd_Feb.Day2;

import java.util.HashMap;
import java.util.Map;

class  Subarray_Sum_Equals_K {
    /*
     * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A    subarray is a contiguous non-empty sequence of elements within an array.
     */
    public int subarraySum(int[] nums, int k) {
        int sum = 0, count =0,i=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        while(i < nums.length)
        {
            sum += nums[i];

            if(map.containsKey(sum-k))
            {
                count+= map.get(sum-k);
            }

            map.put(sum, map.getOrDefault(sum,0)+1);
            i++;
        }

        return count;
    }
    // please solve remaiming qns and also see the discussion please
    //https://leetcode.com/problems/count-number-of-nice-subarrays/description/
}