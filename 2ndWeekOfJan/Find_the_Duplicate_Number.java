public class Find_the_Duplicate_Number {

    /*
     * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
    There is only one repeated number in nums, return this repeated number.
    You must solve the problem without modifying the array nums and using only constant extra space.
     */
    public int findDuplicate(int[] nums) {
        // we have to use cyclic sort
        sort(nums);

        for(int i=0;i<nums.length;i++)
        {
            if(i != nums[i]-1)
            {
                return nums[i];
            }
        }

        return -1;
    }

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