public class CLASS
{

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

class Trie {
    private Trie[] children;
    boolean isEnd;

    public Trie() {
        children=new Trie[26];
        isEnd=false;
    }

    public void insert(String word) {
        Trie node=this;
        for (int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            int index=c-'a';
            if (node.children[index]==null)node.children[index]=new Trie();
            node=node.children[index];
        }
        node.isEnd=true;
    }

    public boolean search(String word) {
        Trie node=this;
        for (int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            int index=c-'a';
            if (node.children[index]==null)return false;
            node=node.children[index];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie node=this;
        for (int i = 0; i < prefix.length(); i++)
        {
            char c = prefix.charAt(i);
            int index=c-'a';
            if (node.children[index]==null)return false;
            node=node.children[index];
        }
        return true;
    }
}
