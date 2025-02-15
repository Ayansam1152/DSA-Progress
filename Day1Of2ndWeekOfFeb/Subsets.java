package Day1Of2ndWeekOfFeb;

import java.util.ArrayList;
import java.util.List;

class Subsets {
    /*
     * Given an integer array nums of unique elements, return all possible subsets(the power set).
        The solution set must not contain duplicate subsets. Return the solution in any order.

        Example 1:
        Input: nums = [1,2,3]
        Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     */
    public List<List<Integer>> subsets(int[] nums) {
        // I have to master the pattern about subset, permutation, combination and all
        List<Integer> template = new ArrayList<>();
        List<List<Integer>> subsets = new ArrayList<>();
        help(nums, 0, template, subsets);

        return subsets;
    }

    private void help(int[] nums, int start, List<Integer> template, List<List<Integer>> subsets)
    {
        // try this problem with others approach as well
        if(start == nums.length) return;

        subsets.add(new ArrayList<>(template));

        for(int idx = start;idx < nums.length;idx++)
        {
            if(template.contains(nums[idx])) continue;

            template.add(nums[idx]);
            help(nums, idx, template,subsets);
            template.remove(template.size()-1);
        }
    }
} 