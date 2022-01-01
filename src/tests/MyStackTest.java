package tests;

import utility.MyQueue;
import utility.MyStack;

import java.util.Stack;

public class MyStackTest {

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t S T A C K    T E S T    P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

    public static void libraryVersionTest(){
        System.out.println();
        System.out.println("------------ L I B R A R Y   S T A C K  --------------");
        Stack<String> stack = new Stack<>();
        stack.push("Red");
        stack.push("Orange");
        stack.push("Yellow");
        stack.push("Green");
        stack.push("Blue");
        stack.push("Indigo");
        stack.push("Violet");

        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }

    public static void myVersionTest(){
        System.out.println();
        System.out.println("------------ M Y   S T A C K --------------");
        MyStack<String> stack = new MyStack<>();
        System.out.println("***read left (top) to right (bottom) as per instructions***");
        System.out.println();
        stack.push("Red");
        stack.push("Orange");
        stack.push("Yellow");
        stack.push("Green");
        stack.push("Blue");
        stack.push("Indigo");
        stack.push("Violet");

        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }



    @SuppressWarnings("UnusedReturnValue")
    public static int removeMin(MyStack<Integer> stack){
        MyStack<Integer> newStack  = new MyStack<>();
        MyStack<Integer> tempStack = new MyStack<>();
        MyQueue<Integer> temp1     = new MyQueue<>();
        MyQueue<Integer> temp2     = new MyQueue<>();

        Integer min = stack.peek();

        for (int i = 0; i < stack.size(); i++) {
            Integer value = stack.pop();
            temp1.add(value);
            if (value < min)
                min = value;
        }

        queueToStack(temp1,tempStack);

        for (int i = 0; i < tempStack.size(); i++){
            Integer value = tempStack.pop();
            if (!value.equals(min))
                temp2.add(value);
        }

        queueToStack(temp2,newStack);

        System.out.println("stack with min value " + min + " removed: "+ newStack);

        return min;
    }

    public static void removeMinTest(){
        System.out.println();
        System.out.println("------------ R E M O V E   M I N --------------");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(4);
        stack.push(12);
        stack.push(7);
        stack.push(2);
        stack.push(3);
        stack.push(2);
        stack.push(11);
        stack.push(3);
        stack.push(8);
        stack.push(2);
        System.out.println("stack before removing mins: " + stack);
        removeMin(stack);
    }

    public static void queueToStack(MyQueue<Integer> queue, MyStack<Integer> stack){
        for (int i = 0; i < queue.size(); i++) {
            Integer data = queue.remove();
            stack.push(data);
        }
    }

    @SuppressWarnings("unused")
    public static void stackToQueue(MyStack<Integer> stack, MyQueue<Integer> queue){
        for (int i = 0; i < stack.size(); i++){
            Integer data = stack.pop();
            queue.add(data);
        }
    }

    public static void main(String[] args) {
        intro();
        libraryVersionTest();
        myVersionTest();
        removeMinTest();
    }
}

