package com.ll;

public class Calc {
    public int run(String text) {
        int res;
        String[] list =  text.split("\\*");
        for(String s: list){
        System.out.println(s);}
        return 1;
    }
    void input(String text){
        for(String s: text){
            System.out.println(s);
        }
    }
}
