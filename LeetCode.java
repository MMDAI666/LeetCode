import org.w3c.dom.Node;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class LeetCode
{
    public static void main(String[] args) throws IOException
    {
        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        System.out.println(new Solution().decodeString(s));
    }
}

class Solution
{
    public String decodeString(String s)
    {
        Deque<Integer> numberStack = new ArrayDeque<>();
        Deque<String> stringStack = new ArrayDeque<>();

        StringBuilder res = new StringBuilder();

        StringBuilder numsb = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0')
            {
                numsb.append(s.charAt(i));
                continue;
            }
            if (s.charAt(i) == ']')
            {
                int k = Objects.requireNonNull(numberStack.pollLast());

                StringBuilder sb = new StringBuilder();
                while (!(Objects.equals(stringStack.peekLast(), "["))) sb.append(stringStack.pollLast());
                stringStack.pollLast();

                stringStack.offerLast(String.valueOf(sb).repeat(k));
                continue;
            }
            if (s.charAt(i) == '[')
            {
                numberStack.offerLast(Integer.valueOf(numsb.toString()));
                numsb.delete(0, numsb.length());
            }
            stringStack.offerLast(String.valueOf(s.charAt(i)));
        }

        if (!stringStack.isEmpty())
        {
            int count = stringStack.size();
            StringBuilder stemp = new StringBuilder();
            for (int i = 0; i < count; i++)
            {
                stemp.append(stringStack.pollFirst()).reverse();
                res.append(stemp);
                stemp.delete(0, stemp.length());
            }
        }
        return res.toString();
    }
}
