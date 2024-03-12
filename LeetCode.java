import org.w3c.dom.Node;

import java.util.*;
import java.util.stream.Collectors;


public class LeetCode {
    public static void main(String[] args) {

    }
}




class Solution {
    public int orangesRotting(int[][] grid) {
        //1.定义2个int数组，2个一组来记录腐烂橘子的上下左右位置。腐烂橘子(0，0)
        int[]dx=new int[]{-1,1,0,0};
        int[]dy=new int[]{0,0,-1,1};

        int step=0;
        int flash=0;

        int row=grid.length;
        int col=grid[0].length;

        Queue<int[]>queue=new ArrayDeque<>();

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (grid[i][j]==1)flash++;
                if (grid[i][j]==2)
                {
                    queue.offer(new int[]{i,j});
                }
            }
        }

        while (flash>0&&!queue.isEmpty())
        {
            step++;
            int size=queue.size();
            for (int i = 0; i < size; i++)
            {
                int[] poll = queue.poll();
                for (int j = 0; j < 4; j++)
                {
                    int x=poll[0]+dx[j];
                    int y=poll[1]+dy[j];
                    if (x>=0&&x<row && y>=0&&y<col &&grid[x][y]==1)
                    {
                        grid[x][y]=2;
                        queue.offer(new int[]{x,y});
                        flash--;
                    }
                }
            }
        }
        return flash>0?-1:step;
    }
}

