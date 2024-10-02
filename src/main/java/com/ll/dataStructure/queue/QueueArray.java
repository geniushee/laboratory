package com.ll.dataStructure.queue;

import java.util.Arrays;

public class QueueArray implements QueueInterface {
    private Integer[] array;
    private int head;
    private int tail;
    private int size;
    private boolean empty;

    private QueueArray() {
        head = 0;
        tail = 0;
        empty = true;
    }

    public QueueArray(int size) {
        this();
        this.size = size;
        array = new Integer[this.size];
    }

    @Override
    public void enqueue(int val) {
        enqueue(val, false);
    }

    public void enqueue(int val, boolean overWrite) {
        if (empty) {
            array[head] = val;
            empty = false;
            return;
        }
        circulate("head");
        if (array[head] == null) {
            array[head] = val;
        } else if (overWrite) {
            array[head] = val;
            circulate("tail");
        } else {
            throw new IllegalArgumentException("queue가 가득 찼습니다.");
        }
    }

    @Override
    public Integer dequeue() {
        if (empty) {
            return null;
        }

        Integer temp = array[tail];
        array[tail] = null;
        circulate("tail");
        if (array[tail] == null) {
            empty = true;
        }
        return temp;
    }

    @Override
    public boolean empty() {
        return empty;
    }

    private void circulate(String pointer) {
        switch (pointer) {
            case "head" -> {
                head++;
                if (head < size) {
                    return;
                } else {
                    head = 0;
                }
            }
            case "tail" -> {
                tail++;
                if (tail < size) {
                    return;
                } else {
                    tail = 0;
                }
            }
        }
    }

    @Override
    public String toString(){
        return Arrays.toString(array);
    }
}
