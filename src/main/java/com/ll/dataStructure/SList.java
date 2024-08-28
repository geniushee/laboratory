package com.ll.dataStructure;

public class SList<T> {

    SimpleListNode<T> head;
    int size;

    public SList(){
        head = null;
        size = 0;
    }

    public SList(T value){
        head = new SimpleListNode<>(value);
        size = 1;
    }

    public void insertFront(T value){
        head = new SimpleListNode<>(value, head);
        size++;
    }

    static class SimpleListNode<T>{
        T value;
        SimpleListNode<T> next;

        public SimpleListNode(T value){
            this(value, null);
        }

        public SimpleListNode(T value, SimpleListNode<T> next){
            this.value = value;
            this.next = null;
        }
    }
}
