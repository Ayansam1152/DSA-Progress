public class Rearrange_an_array
{
    /*
     * Given an array of size n where all elements are distinct and in the range from 0 to n-1, 
     * change the contents of arr[] so that arr[i] = j is changed to arr[j] = i. 
     * Input: arr[]  = {1, 3, 0, 2};
        Output: arr[] = {2, 0, 3, 1};
        Explanation for the above output.
        Since arr[0] is 1, arr[1] is changed to 0
        Since arr[1] is 3, arr[3] is changed to 1
        Since arr[2] is 0, arr[0] is changed to 2
        Since arr[3] is 2, arr[2] is changed to 3
    */

    public void rearrangeArray(int[] nums)
    {
        // brute force 
        int[] res = new int[nums.length];

        for(int i=0;i<nums.length;i++)
        {
            int newIndex = nums[i];
            res[newIndex] = i;
        }

        for(int i=0;i<nums.length;i++)
        {
            nums[i] = res[i];
        }
    }
}