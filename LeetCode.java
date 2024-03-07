import java.util.*;


public class LeetCode {
    public static void main(String[] args) {


    }
}


/*
*
*
以数组 intervals 表示若干个区间的集合，
* 其中单个区间为 intervals[i] = [starti, endi] 。
* 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。


*/
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length==0)return new int[0][2];
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res=new ArrayList<>();
        res.add(intervals[0]);
        int count=0;
        for (int i = 1; i < intervals.length; i++) {
          if (intervals[i][0]<=res.get(count)[1]) {
              if (intervals[i][1]>res.get(count)[1]) res.get(count)[1] = intervals[i][1];
          }
          else {
              count++;
              res.add(intervals[i]);
          }
        }

        return res.toArray(new int[res.size()][]);

    }
}
