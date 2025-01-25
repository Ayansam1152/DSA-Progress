public class Reverse_Words_in_a_String {
    /*
     * Given an input string s, reverse the order of the words.
        A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
        Return a string of the words in reverse order concatenated by a single space.
        Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
     */

     /*
      * Example 3:
        Input: s = "a good   example"
        Output: "example good a"
        Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
      */
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=arr.length-1;i>=0;i--)
        {
            if(!arr[i].trim().isEmpty())
            {
                sb.append(arr[i]+" ");
            }
        }

        return sb.toString().trim();
    }
}