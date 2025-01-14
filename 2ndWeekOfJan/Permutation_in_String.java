public class Permutation_in_String {
    /*
     * Given two strings s1 and s2, return true if s2 contains a permutation
        of s1, or false otherwise.
        In other words, return true if one of s1's permutations is the substring of s2.
     */
    public boolean checkInclusion(String s1, String s2) {
        long firstSum = compute(s1);
        int[] firstFrq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            firstFrq[s1.charAt(i) - 'a']++;
        }

        for (int j = 0; j <= s2.length() - s1.length(); j++) {
            String s = s2.substring(j, j + s1.length());
            long SecSum = compute(s);

            boolean isMatch = false;
            if (firstSum == SecSum) {
                int[] SecFrq = new int[26];
                isMatch = true;
                for (int i = 0; i < s.length(); i++) {
                    SecFrq[s.charAt(i) - 'a']++;
                }

                for (int i = 0; i < 26; i++) {
                    if (firstFrq[i] != SecFrq[i]) {
                        isMatch = false;
                        break;
                    }
                }
            }

            if (isMatch)
                return true;
        }

        return false;
    }

    private long compute(String s) {
        long sum = 0;
        for (char c : s.toCharArray()) {
            sum = sum + c - 'a';
        }

        return sum;
    }
}