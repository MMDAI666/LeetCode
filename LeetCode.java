import java.util.*;
import java.util.stream.Collectors;


public class LeetCode {
    public static void main(String[] args) {
        int [][] ma={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        new Solution().rotate(ma);
        System.out.println(Arrays.deepToString(ma));

    }
}


class Solution {

    public void rotate(int[][] matrix) {
        int temp=0;
        //对角线交换
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j =i+1; j < n; j++) {
                //交换（i，j）和（j，i）
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //逐行逆序
        for (int i = 0; i < n; i++) {
            for (int j =0; j < n/2; j++) {
                temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];
                matrix[i][n-j-1]=temp;
            }
        }

    }
}

