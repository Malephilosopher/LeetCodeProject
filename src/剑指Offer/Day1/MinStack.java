package 剑指Offer.Day1;

import java.util.*;

public class MinStack {

    private Deque<Integer> stack;
    private List<Integer> list;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        list = new ArrayList<>();
    }

    public void push(int x) {
        stack.push(x);
        if(list.isEmpty() || x <= list.get(list.size() - 1)){
            list.add(x);
        }
    }

    public void pop() {
        int num = stack.pop();
        if(!list.isEmpty()){
        if(num == list.get(list.size() - 1)){
            list.remove(list.size() - 1);
        }}
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return list.get(list.size() - 1);
    }
}
