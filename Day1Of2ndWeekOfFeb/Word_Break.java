package Day1Of2ndWeekOfFeb;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Word_Break {
    /*
     * Given a string s and a dictionary of strings wordDict, return true 
     * if s can be segmented into a space-separated sequence of one or more dictionary words.
        Note that the same word in the dictionary may be reused multiple times in the segmentation.
     */
    boolean[] memo = new boolean[301];
    public boolean wordBreak(String s, List<String> wordDict) {
        /*
         * Example 2:
            Input: s = "applepenapple", wordDict = ["apple","pen"]
            Output: true
            Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
            Note that you are allowed to reuse a dictionary word.
         */
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }

        return solve(s,0,set);

        /*
         * Good try but not successfull keep practicing.
         * Set<String> set = new HashSet();
         * Set<String> seen = new HashSet();
         * for(String word : wordDict)
         * {
         * set.add(word);
         * }
         * 
         * int i=0, pre = 0;
         * while(i < s.length())
         * {
         * String sub = s.substring(pre,i+1);
         * 
         * System.out.println(sub);
         * if(set.contains(sub))
         * {
         * if( i == s.length()-1)
         * {
         * return true;
         * }
         * 
         * seen.add(sub);
         * set.remove(sub);
         * 
         * pre = i+1;
         * }
         * else if(seen.contains(sub))
         * {
         * if( i == s.length()-1)
         * {
         * return true;
         * }
         * pre = i+1;
         * }
         * i++;
         * }
         * 
         * return false;
         */

    }

    private boolean solve(String s, int idx, Set<String> set) {
        // Still not optimized you have to check it out
        if (idx == s.length()) {
            return true;
        }

        if (set.contains(s))
            return true;
            
        
        if(memo[idx]) return true;

        for (int l = idx; l < s.length(); l++) {
            String sub = s.substring(idx, l+1);
            //System.out.println(sub);
            if (set.contains(sub) && solve(s,l+1, set)) {
                memo[idx] = true;
                return true;
            }
        }

        return memo[idx] = false;
    }
}