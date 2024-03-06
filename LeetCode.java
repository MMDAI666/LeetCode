import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class LeetCode {
    public static void main(String[] args) {


    }
}


/*
*
143. 重排链表
* 给定一个单链表 L 的头节点 head ，单链表 L 表示为：

L0 → L1 → … → Ln - 1 → Ln
请将其重新排列后变为：

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
*/
//Definition for singly-linked list.
 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public void reorderList(ListNode head) {

        List<ListNode> list=new ArrayList<>();
        ListNode ans=head;
        while (head!=null)
        {
            list.add(head);
            head=head.next;
        }


        int len=list.size();
        int j=len-1;
        boolean flag=true;
        for (int i = 0; i <j; ) {
            //ans=ans.next;
            //ans=list.get(i);
            if (ans==null)return;
            if (flag)
            {
                ans.next=list.get(j);
                j--;
                flag=false;
            }
            else {
                ans.next=list.get(i);
                i++;
                flag=true;
            }
            ans=ans.next;
        }
        ans.next=null;


    }

}
