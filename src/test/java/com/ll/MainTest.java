package com.ll;

import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void t1(){
        System.out.println(SampleEnum.values());
    }

    @Test
    public void t2(){
        for (SampleEnum str : SampleEnum.values()){
            System.out.println(str);
        }
    }
}
