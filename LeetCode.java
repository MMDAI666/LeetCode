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
    long pre=Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root==null)return true;
        boolean l = isValidBST(root.left);
        if (root.val<=pre)return  false;
        pre= root.val;
        boolean r = isValidBST(root.right);
        return l&&r;

    }
}


