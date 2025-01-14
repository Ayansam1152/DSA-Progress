import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    /*
     * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
     */
    public List<Integer> majorityElement(int[] nums) {
        // Same as moore voting algo but little change cause more than n/k element has at most k-1 elements only 
        Integer maj1 = null, maj2 = null;
        int count1 = 0, count2 = 0;
        int n = nums.length;
        for(int i=0;i<nums.length;i++)
        {
            if(maj1 != null && nums[i] == maj1)
            {
                count1++;
            }
            else if(maj2 != null && nums[i] == maj2)
            {
                count2++;
            }
            else if(count1 == 0)
            {
                maj1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0)
            {
                maj2 = nums[i];
                count2 = 1;
            }
            else
            {
                count1--;
                count2--;
            }
        }

        List<Integer> result = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for(int i=0;i<n;i++)
        {
            if(maj1 != null && nums[i] == maj1)
            {
                count1++;
            }
            else if(maj2 != null && nums[i] == maj2)
            {
                count2++;
            }
        }

        if(count1 > Math.floor(n/3))
        {
            result.add(maj1);
        }

        if(count2 > Math.floor(n/3))
        {
            result.add(maj2);
        }

        return result;
        
        // With O(N) Space
        /* Simple using sorting...
         * Arrays.sort(nums);
         * List<Integer> majorityElements = new ArrayList<>();
         * int count = 1;
         * int n = nums.length;
         * for (int i = 1; i < nums.length; i++) {
         * if (nums[i] == nums[i - 1]) {
         * count++;
         * } else {
         * if (count > n / 3) {
         * majorityElements.add(nums[i - 1]);
         * }
         * 
         * count = 1;
         * }
         * }
         * 
         * if (count > n / 3) {
         * majorityElements.add(nums[n - 1]);
         * }
         * 
         * return majorityElements;
         */
    }
}