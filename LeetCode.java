import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class LeetCode {
    public static void main(String[] args) {


    }
}


/*
*
53. 最大子数组和
* 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

子数组
是数组中的一个连续部分。
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int len=nums.length;
        int[] dp=new int[len];
        int ans=nums[0];
        dp[0]=nums[0];
        for (int i = 1; i < len; i++) {
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            if (dp[i]>ans)ans=dp[i];
        }
        return ans;
    }

    public int maxSubArray(int[] nums) {
        int len=nums.length;
        int pre=nums[0];
        int ans=nums[0];

        for (int i = 1; i < len; i++) {
            pre=Math.max(pre+nums[i],nums[i]);
            if (pre>ans)ans=pre;
        }
        return ans;
    }
}
