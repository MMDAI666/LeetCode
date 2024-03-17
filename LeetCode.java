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

class Solution
{
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n)
    {

        int[] col = new int[n];
        Arrays.fill(col, -1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        back(n, col,columns, diagonals1, diagonals2, 0);

        return ans;

    }

    private void back(int n, int[] col, Set<Integer> columns,Set<Integer> diagonals1, Set<Integer> diagonals2, int r)
    {
        if (r == n)
        {
            ans.add(creat(col));
            return;
        }

        for (int i = 0; i < n; i++)
        {
            if (!columns.contains(i) && !diagonals1.contains(i - r) && !diagonals2.contains(i + r))//表示对角线不冲突
            {
                diagonals1.add(i - r);
                diagonals2.add(i + r);
                columns.add(i);
                col[r] = i;
                back(n, col, columns,diagonals1, diagonals2, r + 1);
                col[r] = -1;
                columns.remove(i);
                diagonals2.remove(i + r);
                diagonals1.remove(i - r);
            }
        }

    }

    private List<String> creat(int[] col)
    {
        List<String> temp = new ArrayList<>();

        for (Integer c : col)
        {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < c; i++)
            {
                s.append(".");
            }
            s.append("Q");
            for (int j = c + 1; j < col.length; j++)
            {
                s.append(".");
            }
            temp.add(s.toString());
        }

        return temp;
    }
}
