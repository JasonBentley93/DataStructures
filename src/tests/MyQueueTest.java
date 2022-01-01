package tests;

import utility.MyQueue;
import utility.MyStack;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueueTest {

    public static void evensBeforeOdds(MyQueue<Integer> queue) {
        MyStack<Integer> stackOdd   = new MyStack<>();
        MyStack<Integer> stackEven  = new MyStack<>();
        MyStack<Integer> netStack   = new MyStack<>();
        MyQueue<Integer> newQ       = new MyQueue<>();

        System.out.println("queue before sort: " + queue);

        for(int i = 1; i<= queue.size(); i++) {
            Integer value = queue.remove();
            if (value % 2 == 0)
                stackEven.push(value);
            else
                stackOdd.push(value);
        }

        for(int i = 1; i<= stackOdd.size(); i++){
            Integer value = stackOdd.pop();
            netStack.push(value);
        }


        for(int i = 1; i<= stackEven.size(); i++){
            Integer value = stackEven.pop();
            netStack.push(value);
        }

        for(int i = 1; i<= netStack.size(); i++) {
            Integer value = netStack.pop();
            newQ.add(value);
        }

        System.out.println("queue after sort: " + newQ);

    }

    public static void evensBeforeOddsTest(){
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(17);
        queue.add(6);
        queue.add(1);
        queue.add(8);
        queue.add(12);
        queue.add(9);
        queue.add(16);
        System.out.println();
        System.out.println("------------ E V E N   B E F O R E   O D D S  --------------");
        evensBeforeOdds(queue);
    }

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t Q U E U E    T E S T    P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

    public static void libraryVersionTest(){
        System.out.println();
        System.out.println("------------ L I B R A R Y   Q U E U E --------------");
        Queue<String> queue = new LinkedList<>();
        queue.add("Red");
        queue.add("Orange");
        queue.add("Yellow");
        queue.add("Green");
        queue.add("Blue");
        queue.add("Indigo");
        queue.add("Violet");

        System.out.println(queue);

        queue.remove();
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        queue.remove();

        System.out.println(queue);
    }

    public static void myVersionTest(){

        System.out.println();
        System.out.println("------------ M Y   Q U E U E --------------");
        System.out.println();
        MyQueue<String> queue = new MyQueue<>();
        queue.add("Red");
        queue.add("Orange");
        queue.add("Yellow");
        queue.add("Green");
        queue.add("Blue");
        queue.add("Indigo");
        queue.add("Violet");

        System.out.println(queue);

        queue.remove();
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        queue.remove();

        System.out.println(queue);
    }


    public static void main(String[] args) {
        intro();
        libraryVersionTest();
        myVersionTest();
        evensBeforeOddsTest();
    }
}
