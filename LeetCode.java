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

    public boolean isPalindrome(ListNode head) {
        ListNode midNode = findMidNode(head);
        ListNode last = reverseList(midNode);
        while (last!=null&&head!=null)
        {
            if (head.val!=last.val)return false;
            last=last.next;
            head=head.next;
        }
        return true;
    }
    public ListNode findMidNode(ListNode head)
    {
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
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
