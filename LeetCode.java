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
    public boolean canPartition(int[] nums) {
        int sum=0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++)
        {
            max=Math.max(max,nums[i]);
            sum+=nums[i];
        }
        //奇数不可能被平分分成两个整数
        if (sum%2==1)return false;

        sum=sum/2;
        if (max>sum)return false;
        else if (max==sum)return true;

        boolean[] dp=new  boolean[sum+1];

        dp[0]=true;


        for (int i = 0; i < nums.length; i++)
        {
            for (int j=sum;j>=nums[i];j--)
            {
                dp[j]=dp[j] | dp[j-nums[i]];
            }
        }
        return dp[sum];
    }
}

