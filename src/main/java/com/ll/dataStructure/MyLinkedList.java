package com.ll.dataStructure;

public class MyLinkedList<T> {
    private LinkedNode<T> head = null;
    private LinkedNode<T> tail = null;
    private int size = 0;

    public T front() {
        return head.value != null ? head.value : null;
    }

    public T back() {
        return tail.value != null ? tail.value : null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void removeValue(T value) {
        if (isEmpty()) {
            return;
        }
        LinkedNode<T> temp = head;
        int i = 0;
        while (i < size) {
            if (temp.value.equals(value)) {
                erase(i);
                return ;
            }
            i++;
            temp = temp.next;
        }
    }

    public void reverse() {
        int i = 0;
        LinkedNode<T> node = tail;
        while (true) {
            node.swap();
            i++;
            if(i == size){
                break;
            }
            node = node.next;
        }
        LinkedNode<T> temp = tail;
        tail = node;
        head = temp;
    }

    public T valueFromEnd(int nth) {
        if (nth < 0 || nth >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (isEmpty()) {
            return null;
        }

        return tail.valueFromEnd(nth).value;
    }

    public void erase(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        LinkedNode<T> temp = head.value_at(index);
        if (index == 0) {
            temp.next.prev = null;
            head = temp.next;
        } else if (index == size - 1) {
            temp.prev.next = null;
            tail = temp.prev;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        size--;
    }

    public void insert(int index, T value) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (isEmpty()) {
            pushFront(value);
        } else {
            LinkedNode<T> ln = head.value_at(index);
            LinkedNode<T> temp = new LinkedNode<>(ln, ln.prev, value);
            ln.prev.next = temp;
            ln.prev = temp;
        }

        size++;
    }

    public T popBack() {
        if (isEmpty()) {
            return null;
        }

        T value = tail.value;
        ;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return value;
    }

    public void pushBack(T value) {
        if (isEmpty()) {
            LinkedNode<T> ln = new LinkedNode<>(value);
            head = ln;
            tail = ln;
        } else {
            tail = new LinkedNode<>(null, tail, value);
            tail.prev.next = tail;
        }
        size++;
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

    public T popFront() {
        if (isEmpty()) {
            return null;
        }
        T value = head.value;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return value;
    }


    public void pushFront(T value) {
        if (isEmpty()) {
            LinkedNode<T> ln = new LinkedNode<>(value);
            head = ln;
            tail = ln;
        } else {
            head = new LinkedNode<>(head, null, value);
            head.next.prev = head;
        }
        size++;
    }

    private static class LinkedNode<T> {
        LinkedNode<T> next;
        LinkedNode<T> prev;
        T value;

        private LinkedNode(T value) {
            this(null, null, value);
        }

        private LinkedNode(LinkedNode<T> next, LinkedNode<T> prev, T value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }

        private LinkedNode<T> value_at(int index) {
            if (index == 0) {
                return this;
            }

            return next.value_at(index - 1);
        }

        private LinkedNode<T> valueFromEnd(int nth) {
            if (nth == 0) {
                return this;
            }

            return prev.valueFromEnd(nth - 1);
        }

        private void swap() {
            LinkedNode<T> t = this.next;
            this.next = this.prev;
            this.prev = t;
        }
    }
}
