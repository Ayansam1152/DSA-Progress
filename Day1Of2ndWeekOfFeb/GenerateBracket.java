package Day1Of2ndWeekOfFeb;

import java.io.*;
import java.util.*;

public class GenerateBracket {
    /*
     * n = '()'
     * m = '{}'
     * you have to generate valid combination like 
     *  (){}{}
        {}(){}
        {}{}()
        (){{}}
        {{}}()
        {}{()}
     */

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<String> result = new ArrayList<>();
        backtrack(0,0,0,0,m,n,"",result);
        for(String s : result)
        {
            System.out.println(s);   
        }
    }

    private static void backtrack(int l1, int r1, int l2, int r2, int m,int n, String s, List<String> result)
    {
        if(s.length() == 2*(m+n))
        {
            // validate the string
            if(isValid(s)) {
                result.add(s);
            }
            return;
        }

        if(l1 < n)
        {
            //s = s+'(';
            backtrack(l1+1,r1,l2,r2, m,n, s+'(', result);
            //s.substring(0,s.length()-1);
        }

        if(r1 < l1)
        {
            //s = s+')';
            backtrack(l1,r1+1,l2,r2, m,n, s+')', result);
            //s.substring(0,s.length()-1);
        }

        if(l2 < m)
        {
            //s = s+'{';
            backtrack(l1,r1,l2+1,r2, m,n, s+'{', result);
            //s.substring(0,s.length()-1);
        }

        if(r2 < l2)
        {
            //s = s+'}';
            backtrack(l1,r1,l2,r2+1, m,n, s+'}', result);
            //s.substring(0,s.length()-1);
        }
    }

    private static boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray())
        {
            if(c == '(' || c == '{')
            {
                stack.push(c);
            }
            else
            {
                if(stack.isEmpty()) return false;
                if(stack.peek() == '(' && c != ')' ||
                    stack.peek() == '{' && c != '}')
                    return false;
                else
                    stack.pop();
            }
        }

        return stack.isEmpty();
    }
}