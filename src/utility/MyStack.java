package utility;

import java.util.EmptyStackException;

/*****************************************************************
 * This class MyStack implements a LIFO data structure using a
 * Singly Linked List (SLL).
 *****************************************************************/

public class MyStack<E> {
    private int       size;
    private Node<E>   first;

    public MyStack(){
        size = 0;
        first = null;
    }

    private void detach(){
        Node<E> current = first;
        first = current.next;
    }

    public E push (E item){
        Node<E> oldFirst = first;
        @SuppressWarnings("UnnecessaryLocalVariable")
        Node<E> newNode = new Node<E> (oldFirst, item);

        first = newNode;
        first.next = oldFirst;
        size++;

        return item;
    }

    public E pop(){
        if (isEmpty())
            throw new EmptyStackException();
        else {
            Node<E> current = first;
            E       data    = current.data;
            detach();
            return data;
        }
    }

    public E peek(){
        if (isEmpty())
            throw new EmptyStackException();
        else
            return first.data;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }


    @Override
    public String toString(){
        if(isEmpty()) {
            return "[empty]";
        }else {
            StringBuilder result = new StringBuilder("[" + first.data);
            for (Node<E> node = first.next; node != null; node = node.next) {
                result.append(", ").append(node.data);
            }
            return result.append("]").toString();
        }
    }

    private static class Node<E>{
        Node<E> next;
        E       data;

        Node(Node<E> next, E data){
            this.next = next;
            this.data = data;
        }

    }
}

