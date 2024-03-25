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

class MedianFinder {
    PriorityQueue<Integer> minpq;
    PriorityQueue<Integer> maxpq;

    public MedianFinder() {
        minpq=new PriorityQueue<>((x,y)->y-x);//大顶堆
        maxpq=new PriorityQueue<>((x,y)->x-y);//小顶堆
    }

    public void addNum(int num) {
        if (minpq.isEmpty())
        {
            minpq.offer(num);
        }else
        {
            if (num<=minpq.peek())
            {
                minpq.offer(num);
                if (minpq.size()>maxpq.size()+1) maxpq.offer(minpq.poll());

            }else
            {
                maxpq.offer(num);
                if(maxpq.size()>minpq.size())minpq.offer(maxpq.poll());
            }
        }

    }

    public double findMedian() {
        if (minpq.size()== maxpq.size())return (minpq.peek()+maxpq.peek())/2.0;
        else return minpq.peek();
    }
}
