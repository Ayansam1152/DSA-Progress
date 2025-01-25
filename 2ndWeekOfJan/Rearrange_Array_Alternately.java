import java.util.Arrays;

public class Rearrange_Array_Alternately {

   /*
    * Given an array of positive integers. Your task is to rearrange the array elements alternatively 
    i.e. first element should be the max value, the second should be the min value, the third should be the second max, 
    the fourth should be the second min, and so on.
    Note: Modify the original array itself. Do it without using any extra space. You do not have to return anything.
    */
    public static void rearrange(int arr[]) {

        // let's try with simple approach later will see the O(1) Space approach.
        int[] rep = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            rep[i] = arr[i];
        }

        Arrays.sort(rep);

        int max = arr.length - 1, min = 0;
        int i = 0;
        while (min <= max) {
            if (i % 2 == 0) {
                arr[i] = rep[max];
                max--;
            } else {
                arr[i] = rep[min];
                min++;
            }

            i++;
        }

        // Your code here
        /*
         * Arrays.sort(arr);
         * 
         * for (int i = 0; i < arr.length / 2; i++) {
         * int temp = arr[i];
         * arr[i] = arr[arr.length - 1 - i];
         * arr[arr.length - 1 - i] = temp;
         * }
         * 
         * int n = arr.length;
         * int i = 1, min =n-1, max = n-1;
         * 
         * while(i < n-1)
         * {
         * if(i%2 == 1)
         * {
         * swap(arr, i, min);
         * min--;
         * }
         * else
         * {
         * swap(arr, i, max);
         * }
         * 
         * i++;
         * }
         */
    }

    @SuppressWarnings("unused")
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
