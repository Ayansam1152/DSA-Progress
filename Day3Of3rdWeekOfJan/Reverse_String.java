package Day3Of3rdWeekOfJan;

public class Reverse_String {
    
    public void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        helpRecursion(s, left, right);
        Math.pow(2, 10);
        /* Two pointer approach
        while(left <= right)
        {
            swap(s, left, right);
            left++;
            right--;
        }
        */
    }

    @SuppressWarnings("unused")
    private void swap(char[] s, int i, int j)
    {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    private void helpRecursion(char[] s, int left, int right)
    {
        if(left > right) return;

        char temp = s[right];
        s[right] = s[left];
        s[left] = temp;

        helpRecursion(s,left+1, right-1);
    }
}