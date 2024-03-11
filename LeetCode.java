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
    int sum=Integer.MIN_VALUE;;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return sum;
    }

    public int maxSum(TreeNode root)
    {
        if (root==null)return 0;
        int left=Math.max(maxSum(root.left),0);
        int right=Math.max(maxSum(root.right),0);
        int maxsum = root.val + left+right;

        sum=Math.max(sum,maxsum);

        return root.val + Math.max(left,right);
    }
}


