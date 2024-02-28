import java.util.*;


public class LeetCode {
    public static void main(String[] args) {


    }
}


/*
15. 三数之和
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请

你返回所有和为 0 且不重复的三元组
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        int n = nums.length;
        for (int a = 0; a < n; a++) {
            if (a>0&&nums[a]==nums[a-1])continue;

            int c=n-1;
            int target=-nums[a];

            for (int b = a+1; b < n; b++) {
                if (b>a+1&&nums[b]==nums[b-1])continue;
                while (b<c && nums[b]+nums[c]>target)c--;
                if (b==c)break;
                if (nums[b]+nums[c]==target)
                {
                    List<Integer> list=new ArrayList<>();
                    Collections.addAll(list,nums[a],nums[b],nums[c]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}

