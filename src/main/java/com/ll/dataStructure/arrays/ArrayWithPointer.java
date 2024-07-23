package com.ll.dataStructure.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayWithPointer {

    /*
    pointer를 이용한 array의 index를 구해보는 예제.
     */
    public static void practice1() throws InterruptedException {
        int max = 20;
        int[] arr = new int[max];
        int pointer = 0;
        for(; pointer < arr.length;){
            arr[pointer] = 10 * pointer++;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[--pointer]);

        pointer -= 3;
        System.out.println(arr[pointer]);

        Scanner sc = new Scanner(System.in);
        boolean button = true;
        while(button){
            System.out.println("현재 pointer : " + pointer + ", max : " + (max-1));
            System.out.println("""
                    Command List
                    ------------- 
                    exit : 종료
                    + : 더하기
                    - : 빼기
                    """);
            System.out.print("명령어를 입력해 주세요 : ");
            String command = sc.nextLine();
            if(!List.of("exit","+","-").contains(command)){
                System.out.println("잘못된 입력입니다.");
                continue;
            }

            switch(command){
                case "exit" -> button = false;
                case "+" -> {
                    System.out.print("더할 값을 입력해 주세요 : ");
                    String val = sc.nextLine();
                    if(max < pointer + Integer.valueOf(val)) throw new RuntimeException("max를 넘었습니다.");
                    pointer += Integer.valueOf(val);
                    System.out.println("결과 : "+arr[pointer] +"\n");
                }
                case "-" -> {
                    System.out.print("뺄 값을 입력해 주세요 : ");
                    String val = sc.nextLine();
                    if(0 > pointer - Integer.valueOf(val)) throw new RuntimeException("0보다 작을 수 없습니다.");
                    pointer -= Integer.valueOf(val);
                    System.out.println("결과 : "+arr[pointer] +"\n");
                }
            }
            Thread.sleep(1000);
        }
        System.out.println("종료합니다.");
    }

    /**
     * 자동적으로 resizing 되는 array를 구현한 클래스
     * <p>array의 크기와 마지막 위치를 표기하는 포인터인 size를 이용한다.</p>
     * <p>element를 추가 또는 제거하는데는 O(1) 또는 O(n)이다. 모든 동작은 최대 O(n)으로 동작한다.(resizing 포함)</p>
     */
    private static class nArray{
        private int[] arr;
        private int size;
        private int capacity;

        nArray(int capacity){
            this.arr = new int[capacity];
            this.size = 0;
            this.capacity = capacity;
        }

        private void resize(){
            if(size >= capacity){
                capacity *= 2;
                int[] temp = new int[capacity];
                for(int i = 0; i < size; i++){
                    temp[i] = arr[i];
                }
                arr = temp;
            }

            if(size <= capacity / 4){
                capacity /= 2;
                int[] temp = new int[capacity];
                for(int i = 0; i < size; i++){
                    temp[i] = arr[i];
                }
                arr = temp;
            }
        }

        public int size(){
            return this.size;
        }

        public int capacity(){
            return this.capacity;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public int at(int index){
            if(index > size){
                throw new ArrayIndexOutOfBoundsException();
            }

            return arr[index];
        }

        public void push(int item){
            arr[size++] = item;
            resize();
        }

        public void insert(int index, int item){
            int temp;
            size++;
            resize(); // capacity 용량 점검
            for(int i = size; i > index;i--){
                arr[i] = arr[i-1];
                }
            arr[index] = item;
        }

        public void prepend(int item){
            insert(0, item);
        }

        public int pop(){
            int res = arr[size--];
            resize();
            return res;
        }

        public void delete(int index){
            for(int i = index;i <size;){
                arr[i] = arr[++i];
            }
            size--;
            resize();
        }

        public void remove(int item){
            for(int i = 0; i < size; i++){
                if(arr[i] == item){
                    delete(i);
                }
            }
        }

        public int find(int item){
            for(int i =0; i < size;i++){
                if(arr[i] == item){
                    return i;
                }
            }
            return -1;
        }

        public String toString(){
            String res = "[";
            System.out.print("[");
            for(int i =0 ; i< size; i++){
                System.out.print(arr[i]);
                res += arr[i];
                if(i != size -1){
                    System.out.print(", ");
                    res += ", ";
                }
            }
            System.out.print("]\n");
            res += "]\n";
            return res;
        }
    }

    public static void practice2() throws Exception {
        nArray narray = new nArray(16);
        System.out.println("** nArray가 비었는가? " + narray.isEmpty());
        System.out.println("0. 초기 capacity와 size \nsize : " + narray.size() + "\ncapacity : " + narray.capacity());

        int a = 5;
        for(int i =0; i < 20; i++){
            narray.push(a++);
            narray.toString();
        }
        System.out.println("** nArray가 비었는가? " + narray.isEmpty());
        System.out.println("1. push 후 capacity와 size \nsize : " + narray.size() + "\ncapacity : " + narray.capacity());
        System.out.println("** nArray.at(5) " + narray.at(5));
        narray.insert(2,5);
        System.out.print("** nArray.insert(2, 5) ");
        narray.toString();
        narray.delete(2);
        narray.toString();
        narray.remove(9);
        narray.toString();
        System.out.println("찾는 수 : 11, 결과 : " +narray.find(11));
        System.out.println("resize 확인하기");
        System.out.println("3. delete 전 capacity와 size \nsize : " + narray.size() + "\ncapacity : " + narray.capacity());
        for(int i =0; i < 13; i++){
            narray.delete(0);
        }
        System.out.println("4. delete 후 capacity와 size \nsize : " + narray.size() + "\ncapacity : " + narray.capacity());
        narray.toString();
    }


}
