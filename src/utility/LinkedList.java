package utility;

import java.util.NoSuchElementException;

/*****************************************************************
 * This class LinkedList implements linked data structures using
 * a Doubly Linked List (DLL).
 *****************************************************************/

public class LinkedList<E> implements List<E>{

    private Node<E>  first;
    private Node<E>  last;
    private int      size;

    public LinkedList(){
        first  = null;
        last   = null;
        size   = 0;

    }

    @Override
    public boolean add(E item){
        int previousSize = size;
        append(item);
        size++;
        return size == (previousSize + 1);
    }

    @Override
    public void add(int index, E item){
        String message = "Invalid Index: " + index + " for Size: " + size;
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException(message);

        else if (index == 0){
            first = new Node<E> (null,first, item);

        }else{
            Node<E> current = first;
            for (int i=0; i<index-1; i++){
                current = current.next;
            }
            current.next = new Node<E> (current.next, item);
        }
        size++;
    }

    private void append (E item){
        Node<E> oldLast = last;
        Node<E> newNode = new Node<E> (oldLast, item);
        last            = newNode;

        if (isEmpty())
            first = newNode;
        else
            oldLast.next = newNode;
    }

    private void checkIndex(int index){
        String message = "Invalid Index: " + index + " for Size: " + size;
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(message);
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean contains(E item) {
        return indexOf(item) != -1;
    }

    private E detach(int index){
        Node<E> current    = node(index);
        Node<E> nodeBefore = current.prev;
        Node<E> nodeAfter  = current.next;
        E       data       = get(index);

        if(nodeBefore == null)
            first = nodeAfter;
        else
            nodeBefore.next = nodeAfter;

        if(nodeAfter == null)
            last = nodeBefore;
        else
            nodeAfter.prev = nodeBefore;

        return data;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public int indexOf(E item) {
        int index = 0;
        if (!isEmpty())
            for (Node<E> node = first; node != null; node = node.next, index++)
                if (node.data.equals(item))
                    return index;
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedIterator();
    }

    @Override
    public boolean isEmpty() {
        return  size == 0;
    }

    private Node<E> node(int index) {
        Node<E> current = first;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E oldItem = detach(index);
        size--;
        return oldItem;
    }

    @Override
    public boolean remove(E item) {
        if (contains(item)) {
            E oldItem = remove(indexOf(item));
            return item.equals(oldItem);
        }
        return false;
    }

    @Override
    public E set(int index, E item) {
        checkIndex (index);
        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        E oldItem = current.data;
        current.data = item;
        return oldItem;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if(isEmpty()) {
            return "[]";
        }else {
            StringBuilder result = new StringBuilder("[" + first.data);
            for (Node<E> node = first.next; node != null; node = node.next) {
                result.append(", ").append(node.data);
            }
            return result.append("]").toString();
        }
    }

    private static class Node<E>{
        Node<E> prev;
        Node<E> next;
        E       data;

        Node(Node<E> prev, E data){
            this(prev, null, data);
        }

        Node(Node<E> prev, Node<E> next, E data){
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
    }

    private class LinkedIterator implements Iterator<E>{
        Node<E> current;
        int     position;
        boolean isRemovable;

        public LinkedIterator() {
            current = first;
            position = 0;
            isRemovable = false;
        }

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public E next() {
            String message = "There are no more items left";
            if (!hasNext())
                throw new NoSuchElementException(message);

            E currentItem = current.data;
            current       = current.next;
            position++;
            isRemovable = true;
            return currentItem;
        }

        @Override
        public void remove() {
            String message = "Unable to remove";
            if(!isRemovable)
                throw new IllegalStateException(message);

            LinkedList.this.remove(position -1);
            isRemovable = false;

        }
    }
}
