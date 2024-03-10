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
    public void flatten(TreeNode root) {
        if (root==null ||(root.left==null&&root.right==null))return;

        while (root!=null)
        {
            while (root.right!=null&&root.left==null)root=root.right;

            TreeNode temp=root.right;
            root.right=root.left;
            root.left=null;
            TreeNode maxRight=root;
            while (maxRight.right!=null)maxRight=maxRight.right;
            maxRight.right=temp;

            root=root.right;
        }

    }
}


