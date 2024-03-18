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
    public int findMin(int[] nums) {
        int n=nums.length;
        int left=0;
        int right=n-1;
        int min=Integer.MAX_VALUE;
        while (left<=right)
        {
            int mid=(left+right)/2;
            if(nums[mid]<min)min=nums[mid];
            if (nums[left]<=nums[mid])
            {
                if (min>nums[left])min=nums[left];
                left=mid+1;


            }else
            {
                right=mid-1;
            }
        }
        return min;
    }
}