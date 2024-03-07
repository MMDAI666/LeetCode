import java.util.*;


public class LeetCode {
    public static void main(String[] args) {

    }
}


class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i]<=n &&nums[i]>=1)
            {
                int temp=nums[i];
                if (nums[i]==nums[temp-1])break;
                nums[i]=nums[temp-1];
                nums[temp-1]=temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=i+1)return i+1;
        }
        return n+1;
    }
}