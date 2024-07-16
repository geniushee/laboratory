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


}
