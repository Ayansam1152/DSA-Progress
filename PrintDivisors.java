import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PrintDivisors {
    /*
     * Given an integer N, print all the divisors of N in the ascending order.
     * Input : 20
     * Output: 1 2 4 5 10 20
     * Explanation: 20 is completely
     * divisible by 1, 2, 4, 5, 10 and 20.
     */
    public static void print_divisors(int n) {
        // code here

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }

        System.out.print(n);
    }

    public static void printWithSQRT(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);

                if (n / i != i) {
                    list.add(n / i);
                }
            }
        }

        Collections.sort(list);

        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}

/*
 * 36
 * 
 * 1 2 3 4 6
   * * * * *
 * 36 18 12 9 6
 * 
 */
