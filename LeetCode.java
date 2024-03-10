import org.w3c.dom.Node;

import java.util.*;
import java.util.stream.Collectors;


public class LeetCode
{
    public static void main(String[] args)
    {

    }
}


class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode()
    {
    }

    TreeNode(int val)
    {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if (root==null)return ans;
        Deque<TreeNode> dq=new ArrayDeque<>();
        dq.offerFirst(root);
        while (!dq.isEmpty())
        {
            int len=dq.size();
            List<Integer> res=new ArrayList<>();
            for (int i = 0; i < len; i++)
            {
                TreeNode temp=dq.pollFirst();
                res.add(temp.val);
                if (temp.left!=null)dq.offerLast(temp.left);
                if (temp.right!=null)dq.offerLast(temp.right);
            }
            ans.add(res);
        }
        return ans;
    }
}


