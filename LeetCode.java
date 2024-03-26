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
    public List<Integer> partitionLabels(String s) {
        int left=0;
        int right=0;
        List<Integer> res=new ArrayList<>();
        int[] endIndex=new int[26];
        for (int i = 0; i < s.length(); i++)
        {
            endIndex[s.charAt(i)-'a']=i;
        }

        for (int i = 0; i < s.length(); i++)
        {
            right=Math.max(right,endIndex[(s.charAt(i))-'a']);
            if (i==right)
            {
                res.add(right-left+1);
                left=right+1;
            }
        }
        return res;
    }
}
