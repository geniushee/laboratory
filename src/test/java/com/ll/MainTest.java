package com.ll;

import com.ll.dataStructure.Heap;
import com.ll.dataStructure.MyLinkedList;
import org.assertj.core.api.Assertions;
import org.assertj.core.description.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;


public class MainTest {

    StringBuilder descriptionBuilder;
    int num = 0;

    @BeforeEach
    public void setAssertionDescriptions(){
        descriptionBuilder = new StringBuilder(String.format("Assertion:%n"));
        Consumer<Description> descriptionConsumer = desc -> descriptionBuilder.append(String.format("%d. %s%n",num++, desc));
        Assertions.setDescriptionConsumer(descriptionConsumer);
    }

    @Test
    @DisplayName("HeapTest")
    public void heapTest() {
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

    @Test
    @DisplayName("ArrayPointer : 자동입력 필요")
    public void arrTest() throws Exception {
//        ArrayWithPointer.practice1();
//        ArrayWithPointer.practice2();
    }

    @Test
    @DisplayName("LinkedList test")
    public void linkedListTest() throws Exception {
        MyLinkedList<Integer> myll = new MyLinkedList<>();
        assertThat(myll.size()).as("How long myll is").isEqualTo(0);
        assertThat(myll.isEmpty()).as("myll is empty?").isTrue();
        myll.pushFront(100);
        assertThat(myll.isEmpty()).as("myll is empty?").isFalse();
        assertThat(myll.size()).as("How long myll is").isEqualTo(1);
        assertThat(myll.value_at(0)).as("check myll value").isEqualTo(100);

        for (int i = 2; i < 5; i++) {
            myll.pushFront(i * 100);
        }
        assertThat(myll.size()).as("How long myll is").isEqualTo(4);
        assertThat(myll.popFront()).as("check myll value").isEqualTo(400);
        assertThat(myll.size()).as("How long myll is").isEqualTo(3);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(descriptionBuilder.toString());
        bw.close();
    }
}
