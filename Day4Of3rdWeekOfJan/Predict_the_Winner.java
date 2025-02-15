class Predict_the_Winner {
    /*
     * Input: nums = [1,5,2]
        Output: fal se ion: Initially, player 1 can choose between 1 and 2. 
        If he chooses 2 (or  1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2). 
        So, final score of player 1 is 1 + 2 = 3, and player 2 is 5. 
        Hence, player 1 will never be the winner and you need to return false.
     */  
    public boolean predictTheWinner(int[] nums) {
        int totalSum = 0;
        for(int num : nums)
        {
            totalSum+= num;
        }

        int p1 = help(nums, 0, nums.length-1);
        int p2 = totalSum - p1;

        return p1 >= p2;
    }

    private int help(int[] a, int i, int j) {
        if (i > j)
            return 0;
        // we are skipping the 2nd player move and assuming his move then calculation 1st player future move.
        int take_i = a[i] + Math.min(help(a, i + 2, j), help(a, i + 1, j - 1));
        int take_j = a[j] + Math.min(help(a, i + 1, j - 1), help(a, i, j - 2));

        return Math.max(take_i, take_j);
    }
}