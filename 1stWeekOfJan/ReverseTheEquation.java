import java.util.ArrayList;

class ReverseTheEquation {
    /*
     * Input:
     * S = "5+2*56-2/4"
     * Output: 4/2-56*2+5
     * Explanation: The equation is reversed with
     * numbers remaining the same.
     */

    String reverseEqn(String S) {
        // your code here
        String op = "-+*/";
        ArrayList<String> list = new ArrayList<>();

        int pre = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (op.indexOf(c) != -1) {
                list.add(S.substring(pre, i));
                pre = i + 1;
                list.add(c + "");
            }
        }

        list.add(S.substring(pre, S.length()));

        StringBuilder sb = new StringBuilder();

        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }

        return sb.toString();
    }
}