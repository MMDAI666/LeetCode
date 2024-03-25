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
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((x,y)->y-x);

        for (int i = 0; i < nums.length; i++)
        {
            pq.add(nums[i]);
        }
        for (int i = 0; i < k-1; i++)
        {
            pq.remove();
        }
        return pq.peek();

    }
}
