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
    Map<Integer,TreeNode>parent =new HashMap<>();
    Set<Integer> visited=new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p!=null)
        {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q!=null)
        {
            if (visited.contains(q.val))return q;
            q=parent.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode root)
    {
        if (root==null)return;
        if (root.left!=null)
        {
            parent.put(root.left.val,root);
            dfs(root.left);
        }
        if (root.right!=null)
        {
            parent.put(root.right.val,root);
            dfs(root.right);
        }
    }
}


