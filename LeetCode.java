import org.w3c.dom.Node;

import java.util.*;
import java.util.stream.Collectors;


public class LeetCode
{
    public static void main(String[] args)
    {

    }
}
class Solution {

    int m;int n;

    int[][] flag;
    public boolean exist(char[][] board, String word)
    {
        m=board.length;
        n=board[0].length;
        flag=new int[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j]==word.charAt(0))
                {
                    flag[i][j]=1;
                    if(back(board,word,1,i,j))return true;
                    flag[i][j]=0;
                }
            }
        }
        return false;
    }


    private boolean back(char[][] board, String word, int index,int x,int y)
    {
        if (index>=word.length())return true;
        int[][] temp=new int[][]
                {
                        {x,y-1},
                        {x,y+1},
                        {x+1,y},
                        {x-1,y}
                } ;
        //（x,y-1）(x-1,y) （x,y+1）(x+1,y)
        for (int[] ints : temp)
        {
            if ((check(ints) && board[ints[0]][ints[1]] == word.charAt(index) && flag[ints[0]][ints[1]]==0) )
            {
                if (index==word.length()-1)return true;
                flag[ints[0]][ints[1]] = 1;
                if(back(board, word, index + 1, ints[0], ints[1]))return true;
                flag[ints[0]][ints[1]] = 0;
            }
        }
        return false;
    }

    private boolean check(int[] ints)
    {
        return 0<=ints[0] && ints[0]<m && 0<=ints[1] && ints[1]<n;
    }
}

