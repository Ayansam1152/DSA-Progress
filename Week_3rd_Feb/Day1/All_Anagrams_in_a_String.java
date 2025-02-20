package Week_3rd_Feb.Day1;

import java.util.ArrayList;
import java.util.List;

class Find_All_Anagrams_in_a_String {
    //https://leetcode.com/problems/find-all-anagrams-in-a-string/solutions/92007/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem/


    /*
     * Example 1:
        Input: s = "cbaebabacd", p = "abc"
        Output: [0,6]
        Explanation:
        The substring with start index = 0 is "cba", which is an anagram of "abc".
        The substring with start index = 6 is "bac", which is an anagram of "abc".
     */
    public List<Integer> findAnagrams(String s, String p) {
        int[] pf = new int[26];
        for(char ch : p.toCharArray())
        {
            pf[ch-'a']++;
        }

        long sum1 = compute(p);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<s.length()-p.length()+1;i++)
        {
            String sub = s.substring(i,i+p.length());

            long sum2 = compute(sub);
            boolean isFound = false;
            if(sum1 == sum2)
            {
                isFound = true;

                int[] f = new int[26];

                for(char ch : sub.toCharArray())
                {
                    f[ch-'a']++;
                }

                for(int j=0;j<f.length;j++)
                {
                    if(pf[j] != f[j])
                    {
                        isFound = false;
                        break;
                    }
                }
            }

            if(isFound)
            {
                list.add(i);
            }
        }

        return list;
    }

    private long compute(String s)
    {
        long sum =0;

        for(char ch : s.toCharArray())
        {
            sum += ch-'0';
        }

        return sum;
    }
}