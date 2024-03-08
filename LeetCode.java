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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null ||list2==null)return list1==null?list2:list1;
        ListNode head;
        if (list1.val<=list2.val)
        {
            head=list1;
            list1= list1.next;
        }else
        {
            head=list2;
            list2=list2.next;
        }
        ListNode res=head;
        while (list1!=null &&list2!=null)
        {
            if (list1.val<=list2.val)
            {
                head.next=list1;
                list1= list1.next;
            }else
            {
                head.next=list2;
                list2=list2.next;
            }
            head=head.next;
        }
        head.next=list1==null?list2:list1;
        return res;
    }
}
