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
    public int numSquares(int n) {
        int[] f=new int[n+1];
        for (int i = 1; i <= n; i++)
        {
            int minn=Integer.MAX_VALUE;
            for(int j=1;j<Math.sqrt(i);j++)
            {
                minn=Math.min(minn,f[i-j*j]);
            }
            f[i]=1+minn;
        }
        return f[n];
    }
}


