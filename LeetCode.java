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
    private int len;
    public int diameterOfBinaryTree(TreeNode root) {
        len=0;
        maxDepth(root);
        return len-1;
    }
    public int maxDepth(TreeNode root) {
        if (root==null)return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        len=Math.max(l+r+1,len);
        return Math.max(r,l)+1;
    }
}


