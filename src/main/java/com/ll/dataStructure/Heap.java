package com.ll.dataStructure;

import java.util.Arrays;

/**
 * <p>자료구조 공부를 위해서 Heap에 대한 공부를 하고 직접 코딩해보는 예제이다.</p>
 * <p>Heap은 완전 이진트리의 일종으로 부모 노드가 자식노드보다 크거나 작은 특징을 갖는 자료구조이다.</p>
 * <p>Java에서는 우선순위 큐가 heap으로 구현이 되어있어서 동일한 것으로 잘못 생각했으나, 이는 다른 것이다. 우선순위 큐는 우선순위에 따라 처리순서가 달라지는 큐를 의미한다.
 * 반면, Heap은 완전이진트리로 최대 또는 최소 노드가 항상 루트 노드에 자리하게 되는 자료구조이다.
 * 우선순위 큐는 구체적인 구현체라기 보다는 개념이며, 이를 실현하게 해주는 것 중 하나가 Heap이 되는 것이다.</p>
 * 최소 힙을 직접 구현했다.
 */
public class Heap {
    private int[] arr;
    private int size;
    private int capacity;

    /**
     * Heap의 초기 크기를 결정
     */
    public Heap(int initCapacity){
        // 0은 사용하지 않기 때문에 +1을 하여 배열을 생성
        this.arr = new int[initCapacity + 1];
        this.size = 0;
        this.capacity = initCapacity;
    }


     //해당 노드의 부모 노드 인덱스를 반환
    private int parent(int idx){return idx / 2;}

    //해당 노드의 하위 왼쪽 노드 인덱스를 반환
    private int leftChild(int idx){return 2 * idx;}

    //해당 노드의 하위 오른쪽 노드 인덱스를 반환
    private int rightChild(int idx){return 2 * idx + 1;}

    /**
     * @return Heap의 길이를 반환
     */
    public int size(){return size;}

    // 노드의 위치 변경을 위한 메소드
    private void swap(int idx1, int idx2){
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    /**
     * Heap에 요소를 추가하는 메소드.
     * <p>요소를 추가할 때, Heap의 최대 크기를 넘길 경우 크기를 2배로 증가
     * <p>Heap의 마지막에 요소를 추가하고 추가한 요소의 대소비교를 하여 정렬
     * @param element 추가하고자 하는 요소
     */
    public void add(int element){
        // 최대 크기 확인 및 증가
        if(size >= capacity){
            capacity *= 2;
            arr = Arrays.copyOf(arr, capacity +1);
        }

        // 요소 추가
        arr[++size] = element;

        // 추가된 마지막 노드부터 재정렬
        int current = size;
        while(current > 1 && arr[current] < arr[parent(current)]){
                swap(parent(current), current);
                current = parent(current);
        }
    }

    /**
     * Heap의 최소 값을 반환
     * @return Heap의 최소값
     */
    public int getMin(){
        if(size < 1){
            throw new RuntimeException("힙이 비었습니다.");
        }
        return arr[1];
    }

    /**
     * Heap의 최소값을 반환하고 제거하는 메소드
     * <p>최소값을 반환하고 마지막 값을 첫번째로 옮긴 후 재정렬</p>
     * @return 제거한 Heap의 최소값
     */
    public int extractMin(){
        if(size < 1){
            throw new RuntimeException("힙이 비었습니다.");
        }
        // 반환할 최소값
        int min = arr[1];

        // 마지막 값을 첫번째 노드로 이동
        arr[1] = arr[size--];
        arr[size + 1] = 0;

//        System.out.println("시작 : " + Arrays.toString(arr));
        // 첫번째 노드부터 재정렬
        int current = 1;
        while(true){
            if(isLeaf(current)){
                break;
            }

            int minIdx = current;
            int left = leftChild(current);
            int right = rightChild(current);

            if(arr[current] > arr[left]){
                minIdx = left;
            }
            if(arr[current] > arr[right]){
                minIdx = right;
            }
            if(arr[left] < arr[right] && minIdx != current){
                minIdx = left;
            }
            // 위치 변동이 없다면 브레이크
            if(minIdx == current){
                break;
            }
            swap(current, minIdx);
            current = minIdx;
//            System.out.println("이동 : " + Arrays.toString(arr));
        }
        return min;
    }

    // 마지막 노드인지 확인
    private boolean isLeaf(int idx) {
        return idx > (size / 2) && idx <= size;
    }

    @Override
    public String toString(){
        String str = "";
        for(int i = 1; i<= size; i++){
            str += (arr[i] + " ");
        }
        return "[" + str +"]";
    }
}
