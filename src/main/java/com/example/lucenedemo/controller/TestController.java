package com.example.lucenedemo.controller;

import com.example.lucenedemo.entity.Hello;
import com.example.lucenedemo.interfaceInfo.LogInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.CountDownLatch;

/**
 * @author chenbiao
 * @version 1.0
 * @description
 * @date 2022/8/4 10:04
 */
@Controller
@RequestMapping("/jvmtest")
public class TestController {
    @RequestMapping("/deadThread")
    public void test(){
        System.out.println("deadThread==================");
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        new Thread(){
            @Override
            public void run() {

                synchronized (s1){

                    s1.append("a");
                    s2.append("1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s2){
                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1);
                        System.out.println(s2);
                    }

                }

            }
        }.start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2){

                    s1.append("c");
                    s2.append("3");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s1){
                        s1.append("d");
                        s2.append("4");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();

    }
    @RequestMapping("/testSync")
    public void testSync(){
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
    @RequestMapping("/redefine")
    public void testRedefine(){
        System.out.println("============================" + new Hello().getName());
    }
    @RequestMapping("/logTest")
    public void test2(){
        System.out.println("测试日志切面-------------------------------");

    }
    @LogInfo
    @RequestMapping("/logInfo")
    public void test3(){
        System.out.println("测试@loginfo日志-------------------------------");

    }
    @RequestMapping("/testThreadOOM")
    public void  testThreadOOM(){
        for (int i = 0; ; i++) {
            System.out.println("i = " + i);
            new Thread(new HoldThread()).start();
        }
    }
}

class Number implements Runnable {
    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {

                if (number <= 100) {

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                } else {
                    break;
                }
            }
        }
    }

}
 class HoldThread extends Thread {
    CountDownLatch cdl = new CountDownLatch(1);

    @Override
    public void run() {
        try {
            cdl.await();
        } catch (InterruptedException e) {
        }
    }
}
