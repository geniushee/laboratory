package com.ll;

import com.ll.dataStructure.Heap;
import com.ll.dataStructure.MyLinkedList;
import org.assertj.core.api.Assertions;
import org.assertj.core.description.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @AfterEach
    public void showTestReport(){
        // 버퍼쓰기가 유리한 경우
        // 대량의 데이터를 출력하거나 복잡한 파일 입출력이 필요한 경우.
        //성능이 매우 중요한 애플리케이션에서, 빈번한 출력 작업을 최적화하려는 경우.
        //파일로 로그를 저장하거나 테스트 중 특정 포맷으로 데이터를 기록할 때.
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        System.out.println(descriptionBuilder);
        descriptionBuilder.setLength(0);
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
        // size 0 체크
        assertThat(myll.size()).as("How long myll is").isEqualTo(0);
        assertThat(myll.isEmpty()).as("myll is empty?").isTrue();

        // pushFront 체크
        myll.pushFront(100);
        assertThat(myll.isEmpty()).as("myll is empty?").isFalse();
        assertThat(myll.size()).as("How long myll is?").isEqualTo(1);
        assertThat(myll.value_at(0)).as("check myll value").isEqualTo(100)
                .as("Is head equal tail?").isEqualTo(myll.back());

        for (int i = 2; i < 5; i++) {
            myll.pushFront(i * 100);
        }
        assertThat(myll.size()).as("How long myll is").isEqualTo(4);
        assertThat(myll.popFront()).as("check myll value").isEqualTo(400);
        assertThat(myll.front()).as("check head value").isEqualTo(300);
        assertThat(myll.back()).as("Isn't tailvalue changed?").isEqualTo(100);
        assertThat(myll.size()).as("How long myll is").isEqualTo(3);

        // pushBack 체크
        myll.pushBack(90);
        assertThat(myll.back()).as("check myll tailvalue").isEqualTo(90);

        // popBack 체크
        assertThat(myll.popBack()).as("check myll popBack()").isEqualTo(90);
        assertThat(myll.back()).as("Is tailvalue changed").isEqualTo(100);
        assertThat(myll.size()).as("How long myll is").isEqualTo(3);

        // insert(index, value) 체크
        myll.insert(2, 50);
        Integer[] checklist = new Integer[]{300,200,50,100};
        for(int i = 0;i < myll.size();i++){
            assertThat(myll.value_at(i)).as("Asc values check").isEqualTo(checklist[i]);
        }

        // erase(index) 체크
        myll.erase(2);
        assertThat(myll.value_at(2)).as("check third value of myll").isEqualTo(100);
        assertThat(myll.size()).as("How long myll is").isEqualTo(3);

        // valueFromEnd(nth) 체크
        assertThat(myll.valueFromEnd(0)).as("check tailvalue").isEqualTo(100);
        assertThat(myll.valueFromEnd(2)).as("check value from end").isEqualTo(300);

        //reverse() 체크
        myll.reverse();
        checklist = new Integer[]{100,200,300};
        for(int i = 0; i < myll.size(); i++){
            assertThat(myll.value_at(i)).as("check each value in myll - index : "+i).isEqualTo(checklist[i]);
            assertThat(myll.valueFromEnd(i)).as("check each value in myll - index : "+i).isEqualTo(checklist[2-i]);
        }
        assertThat(myll.front()).as("check head value").isEqualTo(100);
        assertThat(myll.back()).as("check tail value").isEqualTo(300);

        // removeValue(value) 체크
        myll.removeValue(300);
        assertThat(myll.size()).as("How long myll is").isEqualTo(2);
        assertThat(myll.front()).as("check head value").isEqualTo(100);
        assertThat(myll.back()).as("check tail value").isEqualTo(200);
    }
}
