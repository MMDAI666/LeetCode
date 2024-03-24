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
    public int[] dailyTemperatures(int[] temperatures)
    {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
        {
            if (stack.isEmpty()) stack.offerLast(i);
            else
            {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peekLast()])
                {
                    int k = stack.pollLast();
                    ans[k] = i - k;
                }
                stack.offerLast(i);
            }
        }
        return ans;
    }
}
