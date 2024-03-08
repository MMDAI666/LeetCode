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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null || l2==null)return l1==null?l2:l1;
        ListNode head=new ListNode(l1.val+ l2.val);
        ListNode res=head;

        l1=l1.next;
       l2=l2.next;
        boolean temp=head.val>=10;
        if (temp)head.val-=10;
        while (l1!=null || l2!=null)
        {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int var=n1+n2;
            if (temp) {
                var ++;
                temp=false;
            }
            if (var>=10) {
                temp = true;
                var-=10;
            }
            head.next=new ListNode(var);
            head=head.next;
            if (l1!=null)l1=l1.next;
            if (l2!=null)l2=l2.next;
        }
        if (temp)head.next=new ListNode(1);
        return res;
    }
}
