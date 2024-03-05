import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class LeetCode {
    public static void main(String[] args) {


    }
}


/*
*
560. 和为 K 的子数组
给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
子数组是数组中元素的连续非空序列。
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans=0;
        for (int i = 0; i < nums.length; i++) {
            int sum= 0;
            for (int j = i; j >=0; j--) {
                sum+=nums[j];
                if (sum==k)ans++;
            }
        }
        return ans;
    }
    public int presubarraySum(int[] nums, int k) {
        int ans=0;
        int pre=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre+=nums[i];
            if (map.containsKey(pre-k))
            {
                ans+=map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);

        }

        return ans;
    }

}
