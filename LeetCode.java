import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class LeetCode {
    public static void main(String[] args) {


    }
}


/*
*
给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
* 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
返回 滑动窗口中的最大值 。
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==1)return new int[]{nums[0]};

        int[] ans=new int[nums.length-k+1];
        int max=nums[0];
        //计算出第一个窗口的max
        for (int i = 0; i < k; i++) {
            if (nums[i]>max) {
                max = nums[i];
            }
        }
        ans[0]=max;
        if (k==nums.length)return ans;

        //计算窗口内最大的数的个数
        int maxNum=0;
        for (int i = 0; i < k; i++) {
            if (nums[i]==max)maxNum++;
        }
        int count=1;
        int r=k;//r为即将进入窗口的元素，l为即将离开窗口的元素

        for (int l = 0; l < nums.length-k; l++) {
            //右边加一个
            if (nums[r]>=max) {
                if (nums[r]==max)
                {
                    maxNum++;
                }else maxNum=1;
                max = nums[r];
            }

            //左边减一个
            if (nums[l]>=max)
            {
                maxNum--;
                if (maxNum==0)
                {//去掉了唯一最大值，更新最大值
                    max=nums[l+1];
                    for (int j=l+1;j<=r;j++)
                    {
                        if (nums[j]>max)max=nums[j];
                    }
                    for (int j=l+1;j<=r;j++)
                    {
                        if (nums[j]==max)maxNum++;
                    }
                }
            }
            r++;
            ans[count++]=max;

        }
        return ans;
    }

    //单调队列
    public int[] maxSlidingWindowByQueue(int[] nums, int k) {
        if (nums.length==1)return new int[]{nums[0]};
        int n=nums.length;
        int[] ans=new int[nums.length-k+1];
        Deque<Integer> deque=new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty()&&nums[i]>=deque.peekLast())
            {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        ans[0]=nums[deque.peekFirst()];

        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;


    }
}
