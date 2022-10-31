package com.example.lucenedemo.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenbiao
 * @version 1.0
 * @description
 * @date 2022/8/26 9:13
 */
public class DemoTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 3, 4, 4, 4, 5, 6, 78));
        List<Integer> collect = list.stream()
                //先将偶数筛选，再去重，返回集合
                .filter(s -> s%2 == 0)
                .distinct()
                .collect(Collectors.toList());

//        Demmo demmo = new Demo1();
//        for (int i=0; i<100000;i++){
//            System.out.println(i);
//        }
//        System.out.println("demo");
//        demmo.run();
//        String a = null;
//        a.toString();
//        System.out.println("end");
    }
}
