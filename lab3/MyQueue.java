package com.company;
import java.util.*;

class MyArray {
    private int v[];
    private int size;

    public MyArray() {
        this(100);
    }

    public MyArray(int length) {
        size = 0;
        v = new int[length];
    }

    public int get(int poz) {
        if(poz < size) {
            return v[poz];
        } else {
            return -1;
        }
    }

    public void set(int pos, int value) {
        v[pos] = value;
        size++;
    }

    public int getSize() {
        return size;
    }
}

public class MyQueue {
    private MyArray queue;
    private int size;
    int last, first;

    public MyQueue() {
        size = 0;
        first = 0;
        last = 0;
        queue = new MyArray();
    }

    int getSize() {
        return size;
    }

    void enqueue(int value) {
        if(size == 0) {
            size = 1;
            last = 0;
            first = 0;
            queue.set(0, value);
        }
        else {
            size++;
            last++;
            queue.set(last, value);
        }
    }

    int dequeue() {
        int root = queue.get(first);
        first++;
        size--;
        return root;
    }

    boolean isEmpty() {
        if(size == 0)
            return true;
        return false;
    }

    public String toString() {
        StringBuilder a = new StringBuilder();

        for(int i = first; i <= last; i++)
            a.append(this.queue.get(i) + " ");
        return a.toString();
    }
}

class Test {
    public static void main(String args[]) {
        MyQueue queue = new MyQueue();
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(10);
        queue.enqueue(-1);
        queue.enqueue(2);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.getSize());
        System.out.println(queue);
        queue.enqueue(9);
        queue.enqueue(queue.dequeue());
        queue.enqueue(11);
        queue.enqueue(22);
        System.out.println(queue);
        while(!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println("");
        System.out.println(queue);
    }
}
