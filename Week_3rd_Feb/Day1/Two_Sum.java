package Week_3rd_Feb.Day1;

import java.util.Arrays;

class Two_Sum {
    // Please refer this also 
    //https://www.geeksforgeeks.org/count-pairs-with-given-sum-in-sorted-array/
    boolean twoSum(int arr[], int target) {
        // code here
        Arrays.sort(arr);
        
        int left = 0, right = arr.length-1;
        
        while(left < right)
        {
            if(arr[left] + arr[right] > target)
            {
                right--;
            }
            else if(arr[left] + arr[right] < target)
            {
                left++;
            }
            else
            {
                return true;
            }
        }
        
        return false;
    }
}