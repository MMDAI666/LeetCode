import org.w3c.dom.Node;

import java.util.*;
import java.util.stream.Collectors;


public class LeetCode {
    public static void main(String[] args) {

    }
}




class Solution {
    public int numIslands(char[][] grid) {
        int ans=0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (dfs(grid,i,j))ans++;
            }
        }
        return ans;
    }

    public boolean dfs(char[][] grid,int r,int c)
    {
        if (!inArea(grid,r,c))return false;
        if (grid[r][c]!='1')return false;

        grid[r][c]='2';

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
        return true;
    }

    private boolean inArea(char[][] grid,int r,int c)
    {
        return 0<=r&&r<grid.length&&0<=c&&c<grid[0].length;
    }
}

