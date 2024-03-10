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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if (root==null)return ans;
        Deque<TreeNode> deque=new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty())
        {
            int len=deque.size();
            for (int i = 0; i < len; i++)
            {
                TreeNode node = deque.poll();
                if (node.left!=null)deque.offer(node.left);
                if (node.right!=null)deque.offer(node.right);
                if (i==len-1)ans.add(node.val);
            }
        }

        return ans;
    }
}


