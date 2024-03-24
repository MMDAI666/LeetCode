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
    public int largestRectangleArea(int[] heights)
    {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++)
        {
            while (!stack.isEmpty() && heights[stack.peekLast()] >= heights[i]) stack.pollLast();
            left[i] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.offerLast(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--)
        {
            while (!stack.isEmpty() && heights[stack.peekLast()] >= heights[i]) stack.pollLast();
            right[i] = stack.isEmpty() ? n : stack.peekLast();
            stack.offerLast(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) maxArea = Math.max(maxArea, (right[i] - left[i] - 1) * heights[i]);

        return maxArea;
    }
}
