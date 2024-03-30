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
    public int lengthOfLIS(int[] nums) {
        if (nums.length==1)return 1;
        int n=nums.length;
        int[] dp=new int[n+1];
        dp[0]=1;
        int m=1;
        for (int i = 0; i < n; i++)
        {
            dp[i]=1;
            for (int j = 0; j < i; j++)
            {
                if (nums[j]<nums[i])dp[i]=Math.max(dp[i],dp[j]+1);
            }
            m=Math.max(m,dp[i]);
        }

        return m;
    }
}


