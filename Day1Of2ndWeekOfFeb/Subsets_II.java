package Day1Of2ndWeekOfFeb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Subsets_II {
    /*
     * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
     * The solution set must not contain duplicate subsets. Return the solution in any order.
        
        Example 1:
        Input: nums = [1,2,2]
        Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Always Remember to sort this type of problem Duplicate
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, new ArrayList<>(), result, 0);

        return result;
    }

    private void backTrack(int[] nums, List<Integer> template, List<List<Integer>> subsets, int start)
    {
        // you cal also do like subset 1 problem
        // you are doing great Vijay, You have solved this question on you own
        subsets.add(new ArrayList<>(template));

        for(int i = start;i<nums.length;i++)
        {
            if(i > start && nums[i] == nums[i-1]) continue;

            template.add(nums[i]);
            backTrack(nums, template, subsets, i+1);
            template.remove(template.size()-1);
        }
    }
}