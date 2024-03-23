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
    public boolean isValid(String s) {
        Deque<Character> stack=new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')stack.offerLast(s.charAt(i));
            else if(s.charAt(i)==')'||s.charAt(i)=='}'||s.charAt(i)==']')
            {
                Character c = stack.peekLast();
                if (c==null||!isOk(c,s.charAt(i)))return false;
                stack.pollLast();
            }
        }
        return stack.isEmpty();
    }

    private boolean isOk(Character c, char c1)
    {
        if (c1==')')return c.equals('(');
        else if (c1=='}')return c.equals('{');
        else if (c1==']')return c.equals('[');
        return false;
    }
}
