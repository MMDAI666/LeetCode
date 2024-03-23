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

class Solution
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;

        if (len % 2 == 1)
        {
            int mid = (len / 2) + 1;
            return (double) getans(nums1, nums2, mid);
        } else
        {
            int mid1 = (len / 2) - 1;
            int mid2 = (len / 2);
            return (getans(nums1, nums2, mid1+1) + getans(nums1, nums2, mid2+1)) / 2.0;
        }

    }

    private int getans(int[] nums1, int[] nums2, int k)
    {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */
        int length1 = nums1.length, length2 = nums2.length;
        int offset1 = 0, offset2 = 0;//代表偏移量
        int kthElement = 0;

        while (true)
        {
            if (offset1 == length1) return nums2[offset2 + k - 1];
            if (offset2 == length2) return nums1[offset1 + k - 1];

            if (k == 1) return Math.min(nums1[offset1], nums2[offset2]);

            int half = (k / 2);

            int index1 = Math.min(offset1 + half, length1) - 1;
            int index2 = Math.min(offset2 + half, length2) - 1;

            if (nums1[index1] > nums2[index2])
            {

                k -= (index2 - offset2 + 1);
                offset2 = index2 + 1;
            } else
            {
                k -= (index1 - offset1 + 1);
                offset1 = index1 + 1;

            }

        }
    }
}
