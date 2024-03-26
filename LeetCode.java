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
    public int rob(int[] nums) {
        int n=nums.length;
        if(n<2)return nums[0];
        //int[] dp=new int[n];

        int p=nums[0];
        int q=Math.max(nums[0],nums[1]);
        int r=Math.max(p,q);

        for (int i = 2; i < n; i++)
        {
            r=Math.max(p+nums[i],q);
            p=q;
            q=r;
            //dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return r;
    }
}
