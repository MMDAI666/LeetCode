import org.w3c.dom.Node;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class LeetCode
{
    public static void main(String[] args) throws IOException
    {

    }
}


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);

        boolean[] dp=new boolean[s.length()+1];

        dp[0]=true;
        for (int i = 0; i <= s.length(); i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (dp[j] && set.contains(s.substring(j,i)))
                {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}


