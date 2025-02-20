package Week_3rd_Feb.Day2;

import java.util.HashMap;
import java.util.Map;

class Contiguous_Array {
    /*
     * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
     */
    public int findMaxLength(int[] nums) {
        // simple logic is one -> sum++ and 0 -> sum--
        // after that same map and sum store as usal
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] == 0)
            {
                sum= sum-1;
            }
            else
            {
                sum = sum+1;
            }
            // standerd pattern please follow 
            if(map.containsKey(sum))
            {
                int len = i- map.get(sum);

                if(len > max)
                {
                    max = len;
                }
            }
            else
            {
                map.put(sum, i);
            }
        }

        return max;
    }
}