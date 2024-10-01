package com.ll.dataStructure.queue;

public class QueueList implements QueueInterface {
    private Node head;
    private Node tail;

    @Override
    public void enqueue(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }
    }

    @Override
    public Integer dequeue() {
        if (head == null) {
            return null;
        }

        Integer temp = head.get();
        head = head.next;

        return temp;
    }

    @Override
    public boolean empty(){
        return head == null;
    }


    protected static class Node {
        private Integer value;
        private Node next;

        public Node(int val, Node next) {
            this.value = val;
            this.next = next;
        }

        public Node(int val) {
            this(val, null);
        }

        public Integer get() {
            return value;
        }
    }

}

