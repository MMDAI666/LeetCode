import org.w3c.dom.Node;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class LeetCode
{
    public static void main(String[] args) throws IOException
    {
        System.out.println(new Solution().distinctIntegers(5));
    }
}

class Solution {
    public int distinctIntegers(int n) {
        Deque<Integer> deque=new ArrayDeque<>();
        deque.add(n);
        Set<Integer> set=new HashSet<>();

        while (!deque.isEmpty())
        {
            Integer head = deque.pollFirst();
            set.add(head);
            for (Integer i = 1; i <= head; i++)
            {
                if (head%i==1)
                {
                    deque.offerLast(i);
                }
            }
        }
        return set.size();
        //return n==1?1:n-1;(数学不难证明)
    }
}
