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
    public int jump(int[] nums) {
        int end=0;
        int step=0;
        int nextEnd=0;
        for (int i = 0; i < nums.length-1; i++)
        {
            nextEnd=Math.max(i+nums[i],nextEnd);

            if (i==end)
            {
                step++;
                end=nextEnd;
            }
        }
        return step;
    }
}