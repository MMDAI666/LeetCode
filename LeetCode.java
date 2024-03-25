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
    public int maxProfit(int[] prices) {
        int n=prices.length;

        int minIndex=0;
        int profit=0;
        for (int i = 0; i < prices.length; i++)
        {
            if (prices[i]<prices[minIndex])minIndex=i;
            if (prices[i]-prices[minIndex]>profit) profit=prices[i]-prices[minIndex];
        }
        return profit;
    }
}