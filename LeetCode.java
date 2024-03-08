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
    public ListNode detectCycle(ListNode head) {

        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if (slow==fast)
            {
                while (head!=slow)
                {
                    head=head.next;
                    slow=slow.next
                }
                return head;
            }
        }

        return null;
    }
}
