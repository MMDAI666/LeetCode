import java.util.HashMap;
import java.util.Map;



public class LeetCode {
    public static void main(String[] args) {
        int[] m_inorder={9,3,15,20,7};
        int[] m_postorder={9,15,7,20,3};
        Solution s=new Solution();
        System.out.println(s.buildTree(m_inorder, m_postorder));

    }
}
class Solution {

    int[] m_inorder;
    int[] m_postorder;
    int rootIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.m_inorder=inorder;
        this.m_postorder=postorder;
        rootIndex=postorder.length-1;
        return help(0, inorder.length - 1);
    }
    public TreeNode help(int left, int right)
    {
        if (left>right)
        {
            return null;
        }
        TreeNode root=new TreeNode(m_postorder[rootIndex]);
        int index = findIndex(rootIndex);
        rootIndex--;
        root.right=help(index+1,right);
        root.left=help(left,index-1);
        return root;
    }

    public int findIndex(int rootIndex)
    {
        for (int i = 0; i < m_inorder.length; i++) {
            if (m_inorder[i]==m_postorder[rootIndex])return i;
        }
        return -1;
    }


}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
