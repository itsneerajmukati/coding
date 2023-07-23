package own_implementation;

import java.util.Arrays;

public class MyArrayList<E> {

    Object[] elements;
    int size;
    int initialCapacity = 10;

    public MyArrayList() {
        this.elements = new Object[initialCapacity];
        size=0;
    }

    public void add(E element) {
        if(size == this.elements.length) {
            grow();
        }
        elements[size]=element;
        size++;
    }

    public void remove(Object obj) {
        if(elements.length==0) {
            throw new IllegalArgumentException("No element in list");
        }
        int i=0;
        for(;i<size;i++) {
            if(elements[i]==null) {
                break;
            }else if(elements[i].equals(obj)){
                break;
            }
        }
        elements[i]=null;
        System.arraycopy(elements, i+1, elements, i, size-i);
        size--;
    }
    public Object get(int index) {
        if(index>size) {
            throw new IllegalArgumentException("Array index out of bound");
        }
        return elements[index];
    }

    private void grow() {
        this.elements = Arrays.copyOf(elements,size*2);
    }
    
}
