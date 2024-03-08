import java.util.*;
import java.util.stream.Collectors;


public class LeetCode {
    public static void main(String[] args) {


    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head==null ||head.next==null)return head;
        ListNode pre=new ListNode(0,head);
        ListNode temp=pre;
        while (temp.next !=null &&temp.next.next !=null)
        {
            ListNode node1=temp.next;
            ListNode node2=temp.next.next;

            temp.next=node2;
            node1.next=node2.next;
            node2.next=node1;

            temp=node1;

        }

        return pre.next;
    }
}