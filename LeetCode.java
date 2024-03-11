import org.w3c.dom.Node;

import java.util.*;
import java.util.stream.Collectors;


public class LeetCode {
    public static void main(String[] args) {

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root==null)return 0;
        int res=rootSum(root,targetSum);
        res+=pathSum(root.left,targetSum);
        res+=pathSum(root.right,targetSum);
        return res;
    }
    public int rootSum(TreeNode root,long targetSum)
    {
        if (root==null)return 0;
        int ret=0;
        int val=root.val;
        if (val==targetSum)ret++;

        ret +=rootSum(root.left,targetSum-val);
        ret +=rootSum(root.right,targetSum-val);
        return  ret;
    }

    public int pathSum2(TreeNode root, int targetSum)
    {
        Map<Long, Integer> prefix = new HashMap<Long, Integer>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    private int dfs(TreeNode root, Map<Long, Integer> prefix,long curr, int targetSum)
    {
        if (root==null)return 0;
        int ret=0;
        curr+=root.val;

        ret=prefix.getOrDefault(curr-targetSum,0);

        prefix.put(curr,prefix.getOrDefault(curr,0)+1);

        ret+=dfs(root.left,prefix,curr,targetSum);
        ret+=dfs(root.right,prefix,curr,targetSum);

        prefix.put(curr,prefix.getOrDefault(curr,0)-1);
        return ret;

    }

}



