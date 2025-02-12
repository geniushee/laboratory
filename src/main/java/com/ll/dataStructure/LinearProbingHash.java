package com.ll.dataStructure;

public class LinearProbingHash<T> {
    private HashData<T>[] arr;
    private int size;

    public LinearProbingHash(int size){
        this.size = size;
        this.arr = new HashData[size];
        for(int i = 0; i < size; i++){
            arr[i] = new HashData<>();
        }
    }

    public int hash(int key, int repeat){
        return (hash(key) + repeat) % size;
    }

    public int hash(int key){
        return key % size;
    }

    // 키가 존재하면 index반환, 삭제되었으면 -2, 없으면 -1, 가득 찼으면 -3
    public int isExist(int key) {
        int repeat = 0;
        int index = hash(key, repeat);
        while(arr[index].flag == 1 || arr[index].flag == 2){
            HashData<T> data = arr[index];
            if(data.key == key){
                return data.flag == 1 ? index : -2;
            }
            index = hash(key, ++repeat);
            if(repeat == size + 1){
                return -3;
            }
        }
        return -1;
    }

    private boolean occupied(int index){
        return arr[index].flag == 1;
    }

    //삽입 또는 업데이트
    public T add(int key, T value){
        int index = isExist(key);
        if(index == -3){
            throw new ArrayIndexOutOfBoundsException("It is full");
        }
        if( index >= 0){
            arr[index].value = value;
            return arr[index].value;
        }

        int repeat = 0;
        index = hash(key);
        while(occupied(index)){
            index = hash(key,++repeat);
        }
        arr[index] = new HashData<>(key, value);
        return arr[index].value;
    }

    //get
    public T get(int key){
        int index = isExist(key);
        if(index >= 0){
            return arr[index].value;
        }else{
            return null;
        }
    }

    //삭제
    public void remove(int key){
        int index = isExist(key);
        if(index >= 0){
            arr[index] = new HashData<>();
        }
    }

    public static class HashData<T> {
        private Integer key;
        private T value;

        private int flag; // 0,1,2 0: 한번도 안들어옴, 1: 있음, 2:삭제됨

        public HashData(){
            this.flag=0;
            key = null;
            value=null;
        }

        public HashData(int key, T value){
            this.flag = 1;
            this.key = key;
            this.value = value;
        }
    }
}
