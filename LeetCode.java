import org.w3c.dom.Node;

import java.util.*;
import java.util.stream.Collectors;


public class LeetCode {
    public static void main(String[] args) {

    }
}




class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int res=0;

        ArrayList<List<Integer>> list=new ArrayList<>(numCourses);
        int[] in=new int[numCourses];

        Queue<Integer> queue=new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) list.add(new ArrayList<>());

        for (int[] p : prerequisites)
        {
            in[p[0]]++;
            list.get(p[1]).add(p[0]);
        }


        for (int i = 0; i < in.length; i++) if (in[i]<=0)queue.offer(i);


        while (!queue.isEmpty())
        {
            Integer poll = queue.poll();
            res++;
            for (Integer i : list.get(poll))
            {
                in[i]--;
                if (in[i]<=0)queue.offer(i);
            }
            if (res>=numCourses)return true;
        }

        return false;


    }
}
