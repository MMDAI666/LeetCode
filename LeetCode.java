import java.util.*;


public class LeetCode {
    public static void main(String[] args) {
        int[] nums ={1,2,3,4};
        System.out.println(Arrays.toString(new Solution().productExceptSelf(nums)));

    }
}


/*
*
*
238. 除自身以外数组的乘积
给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。

题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。

请 不要使用除法，且在 O(n) 时间复杂度内完成此题。

*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len= nums.length;
        int[] pre=new int[len];
        pre[0]=1;
        int[] next=new int[len];
        next[len-1]=1;
        for (int i = 1; i < len; i++) {
            pre[i]=nums[i-1]*pre[i-1];
            next[len-1-i]=nums[len-i]*next[len-i];
        }
        int[] res=new int[len];
        for (int i = 0; i < res.length; i++) {
            res[i]=pre[i]*next[i];
        }
        return res;

    }
}