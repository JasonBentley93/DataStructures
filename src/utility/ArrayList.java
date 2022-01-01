package utility;

import java.util.NoSuchElementException;

/*****************************************************************
 * This class ArrayList implements a contiguous block of data
 * using an array.
 *****************************************************************/

public class ArrayList<E> implements List<E> {

    static final int DEFAULT_CAPACITY = 10;

    private E[] data;
    private int size;

    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity){
        if (capacity < 0)
            throw new IllegalArgumentException("capacity cannot be negative");

        data = (E[]) new Object[capacity];
        size = 0;
    }

    @Override
    public boolean add(E item){
        ensureCapacity(size+1);
        int oldSize = size;
        data[size] = item;
        size++;
        return size == (oldSize +1);
    }

    @Override
    public void add(int index, E item){
        ensureCapacity(size+1);
        shiftRight(index);
        data[index] = item;
        size++;

    }

    private void checkIndex(int index){
        String message = "Invalid index: " + index + " for size: " + size;
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(message);
    }

    @Override
    public void clear() {
        size = 0;
        data = null;
    }

    @Override
    public boolean contains(E item) {
        return indexOf(item) != -1;
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity (int newCapacity){
        if (newCapacity > data.length){
            int newLength = Math.max(2 * data.length + 1, newCapacity);
            E[] newArray = (E[]) new Object[newLength];

            for (int i = 0; i < size; i++){
                newArray[i] = data[i];
            }
            data = newArray;
        }
    }
    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public int indexOf(E item) {
        for (int index = 0; index < size; index++)
            if (data[index].equals(item))
                return index;
            return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E oldItem = data[index];
        shiftLeft(index);
        data[size-1] = null;
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
        checkIndex(index);
        E oldItem = data[index];
        data[index] = item;
        return oldItem;
    }

    private void shiftLeft(int index){
        for (int i = index; i < size - 1; i++)
            data[i] = data[i +1];
    }

    private void shiftRight(int index){
        for (int i = size-1; i >= index; i--)
            data[i+1] = data[i];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[]";
        else {
            StringBuilder result = new StringBuilder("[" + data[0]);
            for (int i = 1; i < size; i++) {
                result.append(", ").append(data[i]);
            }
            result.append("]");
            return result.toString();
        }
    }


    private class ArrayIterator implements Iterator<E>{
        int      position;
        boolean  isRemovable;

        public ArrayIterator(){
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

            E currentItem = data[position];
            position++;
            isRemovable = true;

            return currentItem;
        }

        @Override
        public void remove() {
            String message = "Unable to remove";
            if(!isRemovable)
                throw new IllegalStateException(message);

            ArrayList.this.remove(position - 1);

            isRemovable = false;

        }
    }

}
