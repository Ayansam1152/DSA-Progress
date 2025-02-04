import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {
    // you can alos pass this into params
    /*
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
        Example 1:
        Input: n = 3
        Output: ["((()))","(()())","(())()","()(())","()()()"]
     */
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        help(0, 0, "", n);
        return result;
    }

    private void help(int left, int right, String s, int n)
    {
        if(s.length() == 2*n)
        {
            result.add(s);
            return;
        }

        if(left < n)
        {
            s = s+'(';
            help(left+1, right,s , n);
            s = s.substring(0,s.length()-1);
        }

        if(right < left)
        {
            s = s+')';
            help(left, right+1, s ,n);
            s = s.substring(0,s.length()-1);
        }
    }
}