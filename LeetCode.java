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
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int left=0;
        int right=n-1;
        int ans=n;
        while (left<=right)
        {
            int mid=(left+right)/2;
            if (nums[mid]==target)return mid;
            if (target<nums[mid])
            {
                ans=mid;
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
        }
        return ans;
    }
}
