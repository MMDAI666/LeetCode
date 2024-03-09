import org.w3c.dom.Node;

import java.util.*;
import java.util.stream.Collectors;


public class LeetCode
{
    public static void main(String[] args)
    {

        LRUCache cache=new LRUCache(2);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}


class LRUCache
{

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private int capacity;
    private int size;
    private DLinkedNode head,tail;

    private HashMap<Integer,DLinkedNode> map;

    public LRUCache(int capacity)
    {
        this.capacity=capacity;
        size=0;
        map=new HashMap<>(capacity);

        head=new DLinkedNode();
        tail = new DLinkedNode();

        head.next=tail;

        tail.prev=head;

    }

    public int get(int key)
    {
        DLinkedNode node = map.get(key);
        if (node==null)return  -1;
        node.prev.next=node.next;
        node.next.prev=node.prev;

        node.prev=head;
        node.next=head.next;

        head.next.prev=node;
        head.next=node;
        return node.value;

    }

    public void put(int key, int value)
    {
        if (map.containsKey(key))
        {
            DLinkedNode node = map.get(key);

            node.prev.next=node.next;
            node.next.prev=node.prev;

            node.prev=head;
            node.next=head.next;

            head.next.prev=node;
            head.next=node;

            node.value=value;

        }
        else if (size>=capacity)
        {

            DLinkedNode node=tail.prev;

            node.prev.next=node.next;
            node.next.prev=node.prev;

            node.prev=head;
            node.next=head.next;

            head.next.prev=node;
            head.next=node;


            map.remove(node.key);
            node.key=key;
            node.value=value;
            map.put(key,node);
        }else
        {
            DLinkedNode node=new DLinkedNode(key,value);
            node.prev=head;
            node.next=head.next;

            head.next.prev=node;
            head.next=node;

            map.put(key,node);
            size++;

        }
    }

}

