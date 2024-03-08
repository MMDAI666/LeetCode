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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair=new ListNode(0,head);
        ListNode pre=hair;
        ListNode tail=hair;

        while (head!=null)
        {
            for (int i = 0; i < k; i++) {
                tail=tail.next;
                if (tail==null)return hair.next;
            }

            ListNode nex=tail.next;
            ListNode[] re=myreverse(head,tail);
            head=re[0];
            tail=re[1];
            tail.next=nex;
            pre.next=head;

            for (int i = 0; i < k; i++) {
                pre=pre.next;
                head=head.next;
            }
        }
        return hair.next;

    }

    private ListNode[] myreverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev!=tail)
        {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail,head};

    }
}