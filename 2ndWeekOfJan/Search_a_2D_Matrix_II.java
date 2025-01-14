public class Search_a_2D_Matrix_II {
    /*
     * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. 
     * This matrix has the following properties:
    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // brute force is simple just iterate through the array and it will work but not efficient
        int row =0, col = matrix[0].length-1;
        while(row < matrix.length && col >=0)
        {
            // this logic is straight forward
            if(target == matrix[row][col]) return true;

            if(target > matrix[row][col])
            {
                row++;
            }
            else
            {
                col--;
            }
        }

        return false;
    }
}