package com.ll.dataStructure;

import java.util.Arrays;

/**
 * 자료구조 공부를 위해서 Heap에 대한 공부를 하고 직접 코딩해보는 예제이다.
 * Heap은 완전 이진트리의 일종으로 부모 노드가 자식노드보다 크거나 작은 특징을 갖는 자료구조이다.
 * .
 * Java에서는 우선순위 큐가 heap으로 구현이 되어있어서 동일한 것으로 잘못 생각했으나, 이는 다른 것이다. 우선순위 큐는 우선순위에 따라 처리순서가 달라지는 큐를 의미한다.
 * 반면, Heap은 완전이진트리로 최대 또는 최소 노드가 항상 루트 노드에 자리하게 되는 자료구조이다.
 * 우선순위 큐는 구체적인 구현체라기 보다는 개념이며, 이를 실현하게 해주는 것 중 하나가 Heap이 되는 것이다.
 * .
 * 최소 힙을 직접 구현했다.
 */
public class Heap {
    private int[] arr;
    private int size;
    private int capacity;

    public Heap(int capacity){
        // 0은 사용하지 않기 때문에 +1을 하여 배열을 생성
        this.arr = new int[capacity + 1];
        this.size = 0;
        this.capacity = capacity;
    }

    private int parent(int idx){return idx / 2;}

    // 해당 노드의 하위 왼쪽 노드 인덱스를 반환
    private int leftChild(int idx){return 2 * idx;}
    // 해당 노드의 하위 오른쪽 노드 인덱스를 반환
    private int rightChild(int idx){return 2 * idx + 1;}

    public int size(){return size;}

    private void swap(int idx1, int idx2){
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    private void add(int element){
        if(size >= capacity){
            capacity *= 2;
            arr = Arrays.copyOf(arr, capacity +1);
        }

        arr[++size] = element;
        int current = size;
        while(current > 1 && arr[current] < arr[parent(current)]){
                swap(parent(current), current);
                current = parent(current);
        }
    }

    @Override
    public String toString(){
        return Arrays.toString(arr);
    }
}
