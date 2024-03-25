import org.w3c.dom.Node;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class LeetCode
{
    public static void main(String[] args) throws IOException
    {

        System.out.println(new Solution());
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        int k=0;
        for (int i = 0; i < nums.length; i++)
        {
            if (k>= nums.length-1)return true;
            if (i<=k)k=Math.max(i+nums[i],k);
        }
        return false;
    }
}