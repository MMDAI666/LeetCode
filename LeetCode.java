import java.util.*;


public class LeetCode {
    public static void main(String[] args) {

    }
}


class Solution {
    public void setZeroes(int[][] matrix) {

        List<int[]> ff=new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]==0) ff.add(new int[]{i, j});
            }
        }
        for (int[] ints : ff) {
            Arrays.fill(matrix[ints[0]], 0);

            for (int j=0;j<matrix.length;j++)
            {
                matrix[j][ints[1]]=0;
            }
        }
    }
}