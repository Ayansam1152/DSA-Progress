package Week_3rd_Feb.Day1;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_Without_Repeating_Characters {
    // Simple sliding window solution
    public int lengthOfLongestSubstring(String s) {
        if(s.length() ==0) return 0;
        Map<Character,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int i=0, j=0;

        while(j < s.length())
        {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch,0)+1);

            if(j-i+1 == map.size())
            {
                max = Math.max(max, map.size());
            }
            else if(j-i+1 > map.size())
            {
                while(j-i+1 > map.size())
                {
                    char ith = s.charAt(i);
                    map.put(ith, map.get(ith)-1);

                    if(map.get(ith) == 0) map.remove(ith);
                    i++;
                }
            }

            j++;
        }

        return max;
    }
}