package com.ll.lab;

public class GenericTypeExample {

    // Generic 클래스 선언
    public class Exem <T> {
        private T element;
    }

    // 2개 이상도 가능하다.
    public static class Exem2 <K, V> {
        private K key;
        private V value;

        public V getValue(K key) {
            if (key.equals(this.key)){
                return value;}
            return null;
        }
    }

    public class sample {}

    // 객체 생성시 Generic Type 선언 필요 - 여기서는 String과 Integer. int와 double같은  primitive type은 사용이 안된다.
    Exem2<String, Integer> a = new Exem2<>();
    Exem<sample> b = new Exem<>();

    public <E> String getE(E o){
        return "";
    }
}
