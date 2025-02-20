package Week_3rd_Feb.Day2;

import java.util.HashMap;
import java.util.Map;

class Subarrays_with_K_Different_Integers {
    /*
     * Given an integer array nums and an integer k, return the number of good subarrays of nums.
        A good array is an array where the number of different integers in that array is exactly k.
        For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
        A subarray is a contiguous part of an array.
     */
    public int subarraysWithKDistinct(int[] nums, int k) {
        // logic is simple cause this problem won't solve just using traditional algorithm
        // that's why count all equal to k and then count for k-1 and substract.
        return subArraysWithN(nums, k) - subArraysWithN(nums, k-1);
    }

    private int subArraysWithN(int nums[], int n)
    {
        Map<Integer,Integer> map = new HashMap<>();
        int count =0, i=0,j=0;

        while(j < nums.length)
        {
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);

            if(map.size() > n)
            {
                while(map.size() > n)
                {
                    map.put(nums[i], map.get(nums[i]) -1);
                    
                    if(map.get(nums[i]) == 0)
                    {
                        map.remove(nums[i]);
                    }
                    i++;
                }
            }

            if(map.size() <= n)
            {
                // no of substring ending at j index
                // we have to count all the subs till index
                count = count + j-i+1;
            }
            j++;
        }

        return count;
    }
}