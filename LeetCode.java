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
    public TreeNode sortedArrayToBST(int[] nums) {
        return getRoot(nums,0,nums.length);

    }

    public static TreeNode getRoot(int[] nums,int left,int right)
    {
        if (left>right)return null;
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=getRoot(nums,left,mid-1);
        root.right=getRoot(nums,mid+1,right);
        return root;
    }
}


