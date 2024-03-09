import org.w3c.dom.Node;

import java.util.*;
import java.util.stream.Collectors;


public class LeetCode
{
    public static void main(String[] args)
    {


    }
}


class ListNode
{
    int val;
    ListNode next;

    ListNode()
    {
    }

    ListNode(int val)
    {
        this.val = val;
    }

    ListNode(int val, ListNode next)
    {
        this.val = val;
        this.next = next;
    }
}

class Solution
{


    public ListNode mergeKLists(ListNode[] lists)
    {
        ListNode pre = new ListNode(0);
        ListNode head = pre;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(((o1, o2) -> o1.val - o2.val));
        for (ListNode list : lists)
        {
            if (list != null)
            {
                pq.add(list);
            }
        }
        ListNode temp = null;
        while (!pq.isEmpty())
        {
            temp = pq.poll();
            head.next = temp;
            temp = temp.next;
            head=head.next;
            if (temp == null) continue;
            pq.add(temp);
        }
        return pre.next;
    }

}