package com.ll;


import com.ll.dataStructure.Heap;

public class Main {
    public static void main(String[] args){
        heapTest();
    }

    public static void heapTest(){
        Heap heap = new Heap(6);
        heap.add(2);
        heap.add(5);
        heap.add(6);
        heap.add(9);
        heap.add(1);
        heap.add(10);
        heap.add(11);
        heap.add(54);
        heap.add(83);
        heap.add(4);

        System.out.println(heap.toString());
        System.out.println(heap.size());
        System.out.println(heap.extractMin());
        System.out.println(heap.toString());
        System.out.println(heap.extractMin());
        System.out.println(heap.toString());
        System.out.println(heap.extractMin());
        System.out.println(heap.toString());
    }
}