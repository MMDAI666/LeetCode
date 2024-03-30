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
    public int maxProduct(int[] nums) {
        int max=nums[0];
        int min=nums[0];
        int ans=nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            int ma=max,mi=min;
            min=Math.min(ma*nums[i],Math.min(mi*nums[i],nums[i]));
            max=Math.max(ma*nums[i],Math.max(mi*nums[i],nums[i]));
            ans=Math.max(ans,max);
        }
        return ans;
    }
}

