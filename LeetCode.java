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
    public ListNode reverseList(ListNode head) {
        if (head==null ||head.next==null)return head;
        ListNode pre=null;
        ListNode behind=head.next;

        while (behind!=null)
        {
            head.next=pre;
            pre=head;
            head=behind;
            behind=head.next;
        }
        head.next=pre;
        return head;
    }
}
