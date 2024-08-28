package com.ll.dataStructure;

public class MyLinkedList<T> {
    LinkedNode<T> head = null;
    LinkedNode<T> tail = null;
    int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T value_at(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (isEmpty()) {
            return null;
        }

        return head.value_at(index).value;
    }



    public T popFront(){
        if(isEmpty()){
            return null;
        }

        T value = head.value;
        head = head.next;
        size--;
        return value;
    }


    public void pushFront(T value) {
        if (isEmpty()) {
            head = new LinkedNode<>(value);
        } else {
            head = new LinkedNode<>(head, value);
        }
        size++;
    }

    private static class LinkedNode<T> {
        LinkedNode<T> next;
        T value;

        private LinkedNode(T value) {
            this(null, value);
        }

        private LinkedNode(LinkedNode<T> next, T value) {
            this.next = next;
            this.value = value;
        }

        public LinkedNode<T> value_at(int index) {
            if (index == 0) {
                return this;
            }

            return next.value_at(index - 1);
        }
    }
}
