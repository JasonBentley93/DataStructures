package utility;

import java.util.NoSuchElementException;

/*****************************************************************
 * This class MyQueue implements a FIFO data structure using a
 * Singly Linked List (SLL).
 *****************************************************************/

public class MyQueue<E> {
    private int       size;
    private Node<E>  first;

    public MyQueue(){
        size = 0;
        first = null;
    }
    public boolean add (E item){
        int previousSize = size;
        append(item);
        size++;
        return size == (previousSize + 1);
    }

    private void append(E item) {

        if (isEmpty()) {
            first = new Node<E>(null, item);
        } else {
            Node<E> current = first;
            for (Node<E> node = first.next; node != null; node = node.next) {
                current = current.next;
            }
            current.next = new Node<E> (current.next, item);
        }
    }

    private void detach(){
        Node<E> current = first;
        first = current.next;
    }

    public E remove(){
        String message = "Queue is empty";
        if (isEmpty())
            throw new NoSuchElementException(message);
        else {
            Node<E> current = first;
            E       data    = current.data;

            detach();
            return data;
        }
    }


    public E peek(){
        if (isEmpty())
            return null;
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
