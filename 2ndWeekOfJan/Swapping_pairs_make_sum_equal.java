import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Swapping_pairs_make_sum_equal {
    /*
     * Given two arrays of integers a[] and b[], the task is to check 
     * if a pair of values (one value from each array) exists such that 
     * swapping the elements of the pair will make the sum of two arrays equal.
     * Input: a[] = [4, 1, 2, 1, 1, 2], b[] = [3, 6, 3, 3]
        Output: true
        Explanation: Sum of elements in a[] = 11, Sum of elements in b[] = 15, 
        To get same sum from both arrays, we can swap following values: 1 from a[] and 3 from b[]
     */
    public boolean findSwapValues(int[] a, int[] b) {
        // Your code goes here ok
        Arrays.sort(a);
        Arrays.sort(b);
        
        int sum1 = 0, sum2 = 0;
        
        for(int num : a)
        {
            sum1+= num;
        }
        
        for(int num : b)
        {
            sum2+= num;
        }
        
        int diff =sum1 - sum2;
        // only even diff can be split not odd edge case
        if(diff%2 != 0) return false;
        // a[i] - b[i] == target (diff/2)
        Map<Integer,Integer> freqMap = new HashMap<>();
        
        for(int num : b)
        {
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
        
        for(int num : a)
        {
            if(freqMap.containsKey(num - (diff/2))) return true;
        }
        
        return false;
    }
}
