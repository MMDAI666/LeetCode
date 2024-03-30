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


class Solution
{
    public int longestValidParentheses(String s)
    {
        int n = s.length();
        int left = 0, right = 0;
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--)
        {
            if (s.charAt(i) == '(') left++;
            else right++;
            if (left == right) len = Math.max(len, left * 2);
            else if (left > right)
            {
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(') left++;
            else right++;
            if (left == right) len = Math.max(len, left * 2);
            else if (left < right)
            {
                left = 0;
                right = 0;
            }
        }
        return len;
    }

    public int longestValidParenthesesWithDp(String s)
    {
        int n=s.length();
        int[] dp=new int[n];
        int max=0;
        for (int i = 1; i < n; i++)
        {
            if (s.charAt(i)==')')
            {
                if (s.charAt(i-1)=='(')dp[i]= (i-2>=0?dp[i-2]:0)+2;
                else if (i-dp[i-1]>0 &&  s.charAt(i-dp[i-1]-1)=='(')
                {
                    dp[i] = dp[i - 1] +
                            ((i - dp[i - 1]) -2 >= 0 ?
                                    dp[i - dp[i - 1] - 2] : 0)
                            + 2;
                }
                max=Math.max(max,dp[i]);
            }
        }
        return max;
    }
}
