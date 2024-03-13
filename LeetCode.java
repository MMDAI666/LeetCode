import org.w3c.dom.Node;

import java.util.*;
import java.util.stream.Collectors;


public class LeetCode {
    public static void main(String[] args) {

    }
}




class Solution {
    private int[] flag;
    private List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        if (nums==null||nums.length==0)return null;
        res=new ArrayList<>();
        flag=new int[nums.length];
        dfs(nums,new ArrayList<Integer>());
        return res;
    }

    private void dfs(int[] nums, ArrayList<Integer> temp)
    {
        if (temp.size()==nums.length)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++)
        {
            if (flag[i]==0)
            {
                flag[i]=1;
                temp.add(nums[i]);
                dfs(nums,temp);
                temp.remove(temp.size()-1);
                flag[i]=0;
            }
        }
    }
}
