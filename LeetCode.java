import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;



public class LeetCode {
    public static void main(String[] args) {


    }
}
class Solution {
    public void moveZeroes(int[] nums) {
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0)
            {
                nums[j]=nums[i];
                j++;
            }
        }
        for (; j < nums.length; j++) {
            nums[j]=0;
        }
    }
}

