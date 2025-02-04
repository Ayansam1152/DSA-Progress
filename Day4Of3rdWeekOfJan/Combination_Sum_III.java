import java.util.ArrayList;
import java.util.List;

class Combination_Sum_III {
    /*
     * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
        Only numbers 1 through 9 are used.
        Each number is used at most once.
        Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        // I am very proud of my self Vijay, solve back to back question, great but still Time complexity you will have to learn
        List<List<Integer>> result = new ArrayList<>();
        help(k,n, 1, new ArrayList<>(), result, 0);
        return result;
    }

    private void help(int k, int n, int start, List<Integer> list, List<List<Integer>> result, int sum)
    {
        if(k == list.size())
        {
            if(sum == n)
            {
                result.add(new ArrayList<>(list));
            }

            return;
        }

        if(sum > n) return;

        for(int i=start;i<=9;i++)
        {
            list.add(i);
            sum = sum+i;
            help(k, n, i+1, list, result, sum);
            sum = sum-list.get(list.size()-1);
            list.remove(list.size()-1);
           
        }
    }
}