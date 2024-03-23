import org.w3c.dom.Node;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class LeetCode
{
    public static void main(String[] args) throws IOException
    {
        System.out.println(new Solution());
    }
}

class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack=new ArrayDeque<>();
        minStack=new ArrayDeque<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        int min=minStack.peek();
        if(val<min)min=val;
        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();

    }

    public int top() {

        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
