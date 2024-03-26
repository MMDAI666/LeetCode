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
    public int climbStairs(int n) {

        int p=0;
        int q=0;
        int r=1;
        for (int i = 0; i <= n; i++)
        {
            p=q;
            q=r;
            r=p+q;
        }
        return r;
    }
}
