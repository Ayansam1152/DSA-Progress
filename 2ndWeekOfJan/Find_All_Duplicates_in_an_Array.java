import java.util.ArrayList;
import java.util.List;

public class Find_All_Duplicates_in_an_Array {
    public List<Integer> findDuplicates(int[] nums) {
        sort(nums);
        List<Integer> duplicates = new ArrayList<>();

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]-1 != i)
            {
                duplicates.add(nums[i]);
            }
        }

        return duplicates;
        // Good but not efficient
        /*
         * int[] frq = new int[100001];
         * for(int num : nums)
         * {
         * frq[num]++;
         * }
         * 
         * List<Integer> duplicates = new ArrayList<>();
         * for(int i=0;i<frq.length;i++)
         * {
         * int val = frq[i];
         * 
         * if(val == 2)
         * {
         * duplicates.add(i);
         * }
         * }
         * 
         * return duplicates;
         */
    }

    // always remember when Range is 1 to N means cyclic sort will apply
    private void sort(int[] nums)
    {
        int i=0;

        while(i < nums.length)
        {
            int correct = nums[i] -1;

            if(nums[i] != nums[correct])
            {
                swap(nums, i, correct);
            }
            else
            {
                i++;
            }
        }
    }

    private void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}