import org.w3c.dom.Node;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class LeetCode
{
    public static void main(String[] args) throws IOException
    {
        int[] a=new int[]{1};
        new Solution().searchRange(a,1);
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int[] res=new int[]{0,n};
        int left=0;
        int right=n-1;
        while (left<=right)
        {
            int mid=(left+right)/2;
            if (target<=nums[mid])
            {
                res[0]=mid;
                right=mid-1;
            }else left = mid + 1;
        }
        left=0;
        right=n-1;
        while (left<=right)
        {
            int mid=(left+right)/2;
            if (target<nums[mid])
            {
                res[1]=mid;
                right=mid-1;
            }else left = mid + 1;
        }
        res[1]--;
        if (res[0]<=res[1] && nums[res[0]]==target && nums[res[1]]==target) return res;
        return new int[]{-1,-1};
    }
}
