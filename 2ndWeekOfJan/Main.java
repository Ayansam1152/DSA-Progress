import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 3, 0, 2};

        Rearrange_an_array obj = new Rearrange_an_array();

        obj.rearrangeArray(nums);

        System.out.print(Arrays.toString(nums));
    }
}
