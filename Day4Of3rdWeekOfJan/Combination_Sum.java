import java.util.ArrayList;
import java.util.List;

class Combination_Sum {
    /*
     * Given an array of distinct integers candidates and a target integer target,
     * return a list of all unique combinations of candidates where the chosen
     * numbers sum to target.
     * You may return the combinations in any order.
     * The same number may be chosen from candidates an unlimited number of times.
     * Two combinations are unique if the
     * frequency
     * of at least one of the chosen numbers is different.
     */

     //NOTE: ALERT BEST Pattern is there
     //https://leetcode.com/problems/combination-sum/solutions/16502/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /*
         * Input: candidates = [2,3,5], target = 8
         * Output: [[2,2,2,2],[2,3,3],[3,5]]
         */
        List<List<Integer>> result = new ArrayList<>();
        help(candidates, target, 0, new ArrayList<>(), result, 0);
        return result;
    }

    private void help(int[] nums, int target, int start, List<Integer> list, List<List<Integer>> result, int sum) {
        if (sum == target) {
            // will check for duplicate also
            result.add(new ArrayList<>(list));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            sum = sum + nums[i];
            list.add(nums[i]);
            help(nums, target, i, list, result, sum);
            sum = sum - nums[i];
            list.remove(list.size() - 1);
        }
    }
}