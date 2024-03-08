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
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ago=head;
        ListNode after=head;
        ListNode pre=null;
        int count=0;
        while (ago!=null && count<n)
        {
            ago=ago.next;
            count++;
        }
        if (count!=n)return null;
        while (ago!=null)
        {
            pre=after;
            ago=ago.next;
            after= after.next;
        }
        if (pre==null)return head.next;
        pre.next=after.next;
        after.next=null;

        return head;

    }
}