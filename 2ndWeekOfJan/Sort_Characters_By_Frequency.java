import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Sort_Characters_By_Frequency {
    /*
     * Constraints:
        1 <= s.length <= 5 * 105
        s consists of uppercase and lowercase English letters and digits.
     */
    public String frequencySort(String s) {
        // Well done Vijay, I am proud of you.
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) ->Integer.compare(map.get(b), map.get(a)));

        pq.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty())
        {
            char key = pq.poll();
            int frq = map.get(key);

            while(frq-->0)
            {
                sb.append(key);
            }

        }

        return sb.toString();
        
        /*
        //NOTE: Always Read questions casrefully then jump to the solutions.
        // let's start coding
        int[] fr = new int[26];
        for(char c : s.toCharArray())
        {
            fr[c-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        while(true)
        {
            int count = 0;
            char ch = '0';
            int index = -1;
            for(int i=0;i<26;i++)
            {
                if(fr[i] > count)
                {
                    count = fr[i];
                    ch =(char) (i+'1');
                    index = i;
                }
            }

            if(count == 0) break;

            if(count != 0)
            {
                while(count-->0)
                {
                    sb.append(ch);
                }
                fr[index] = 0;
            }
        }

        return sb.toString();
        */
    }
}