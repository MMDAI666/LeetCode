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
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int left=0;
        int right=m-1;
        int index=0;
        while (left<=right)
        {
            int mid=(left+right)/2;
            if (matrix[mid][0]==target)return true;
            if (target<matrix[mid][0]) right=mid-1;
            else
            {
                index=mid;
                left = mid + 1;
            }
        }

        left=0;
        right=n-1;
        while (left<=right)
        {
            int mid=(left+right)/2;
            if (matrix[index][mid]==target)return true;
            if (target<matrix[index][mid])right=mid-1;
            else left=mid+1;
        }
        return false;

    }
}
