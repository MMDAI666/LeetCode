import org.w3c.dom.Node;

import java.util.*;
import java.util.stream.Collectors;


public class LeetCode {
    public static void main(String[] args) {


    }
}



class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;
        int length=0;
        ListNode node=head;
        while (node!=null)
        {
            node=node.next;
            length++;
        }
        ListNode pre=new ListNode(0,head);
        for (int subLength=1;subLength<length;subLength=subLength*2)
        {
            ListNode prev=pre,curr=pre.next;
            while (curr!=null)
            {
                ListNode head1=curr;
                for (int i=1;i<subLength&&curr.next!=null;i++)
                {
                    curr=curr.next;
                }
                ListNode head2=curr.next;
                curr.next=null;
                curr = head2;
                for (int i=1;i<subLength&&curr!=null&& curr.next != null;i++)
                {
                    curr=curr.next;
                }
                ListNode nex=null;
                if (curr!=null)
                {
                    nex=curr.next;
                    curr.next=null;
                }
                ListNode merge = merge(head1, head2);
                prev.next=merge;
                while (prev.next!=null)
                {
                    prev=prev.next;
                }
                curr=nex;
            }
        }
        return pre.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

}