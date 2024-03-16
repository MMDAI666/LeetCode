import org.w3c.dom.Node;

import java.util.*;
import java.util.stream.Collectors;


public class LeetCode
{
    public static void main(String[] args)
    {

    }
}
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len=candidates.length;
        List<List<Integer>> res=new ArrayList<>();
        if (len==0)return res;
        Arrays.sort(candidates);
        Deque<Integer> stack=new ArrayDeque<>();
        dfs(candidates,0,len,target,stack,res);
        return res;
    }

    private void dfs(int[] candidates, int start, int end, int target, Deque<Integer> stack, List<List<Integer>> res)
    {
        if (target == 0)
        {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = start; i < end; i++)
        {
            if (target-candidates[i]<0)break;
            stack.offer(candidates[i]);
            dfs(candidates,i,end,target-candidates[i],stack,res);
            stack.removeLast();
        }
    }

}


