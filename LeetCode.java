import org.w3c.dom.Node;

import java.util.*;
import java.util.stream.Collectors;


public class LeetCode {
    public static void main(String[] args) {

    }
}




class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        int subLen=1<<n;
        List<List<Integer>> res=new ArrayList<>();
        for (int i = 0; i < subLen; i++)
        {
            List<Integer> temp=new ArrayList<>();
            for (int j = 0; j < n; j++)
            {
                if ((i&(1<<j))!=0)
                {
                    temp.add(nums[j]);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
