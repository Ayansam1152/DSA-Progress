import java.util.ArrayList;
import java.util.List;

class Combinations {
    /*
     * Example 1:
    Input: n = 4, k = 2
    Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
    Explanation: There are 4 choose 2 = 6 total combinations.
    Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
     */
    public List<List<Integer>> combine(int n, int k) {
        // you should be proud of yourself but please time complexcity is issue for you please go through it
        List<List<Integer>> result = new ArrayList<>();
        com(n,k,new ArrayList<Integer>(), 1,result);

        return result;
    }

    private void com(int n, int k, List<Integer> list, int start, List<List<Integer>> result)
    {
        if(list.size() == k)
        {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i= start;i<=n;i++)
        {
            list.add(i);
            com(n, k, list,i+1,result);
            list.remove(list.size()-1);
        }
    }
}