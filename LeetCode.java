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
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map=new HashMap<>(preorder.length);
        for (int i = 0; i < inorder.length; i++)
        {
            map.put(inorder[i],i );
        }

        return getRoot(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode getRoot(int[] preorder, int[] inorder,int preleft,int preright,int inoleft,int inoright)
    {
        if (preleft>preright && inoleft>inoright)return new TreeNode(preorder[preleft]);

        Integer rootIndex = map.get(preorder[preleft]);
        int len=rootIndex-inoleft;
        TreeNode root=new TreeNode(preorder[preleft]);
        root.left=getRoot(preorder,inorder,preleft+1,preleft+len,inoleft, rootIndex-1);
        root.right=getRoot(preorder,inorder,preleft+len+1,preright, rootIndex+1,inoright);
        return root;
    }
}


