import org.w3c.dom.Node;

import java.util.*;
import java.util.stream.Collectors;


public class LeetCode
{
    public static void main(String[] args)
    {

    }
}
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        backtrack(ans,n,new StringBuilder(), 0,0);
        return ans;
    }

    private void backtrack(List<String> ans, int n, StringBuilder stringBuilder, int close, int open)
    {
        if (stringBuilder.length()==n*2)
        {
            ans.add(stringBuilder.toString());
            return;
        }
        if (close<n)
        {
            stringBuilder.append("(");
            backtrack(ans,n,stringBuilder,close+1,open);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        if (open<close)
        {
            stringBuilder.append(")");
            backtrack(ans,n,stringBuilder,close,open+1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}


