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
    private static final boolean WHITE=true;
    private static final boolean GREY=false;
    public int kthSmallest(TreeNode root, int k) {
        if (root==null) return 0;
        int count=0;
        Deque<Object> stack=new LinkedList<>();
        stack.push(root);
        stack.push(WHITE);
        while (!stack.isEmpty())
        {
            boolean flag=(boolean) stack.pop();
            TreeNode node=(TreeNode)stack.pop();
            if (node==null)continue;
            if (flag)
            {
                stack.push(node.right);
                stack.push(WHITE);
                stack.push(node);
                stack.push(GREY);
                stack.push(node.left);
                stack.push(WHITE);
            }else count++;
            if (count==k)return node.val;
        }
        return 0;
    }
}

