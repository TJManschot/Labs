package nl.belastingdienst.h13.opgave5;

import java.util.Arrays;

public class MyIntCollection<T> {
    private Object[] collection;
    int index;

    public MyIntCollection() {
        collection = new Object[4];
        index = 0;
    }

    public void add(T t) {
        if (index >= collection.length) {
            collection = Arrays.copyOf(collection, 2 * collection.length);
        }
        collection[index++] = t;
    }

    public T get(int i) {
        if (i < 0 || i > index) {
            String error_message = "Index i = " + i + " not in [0, " + index + ")";
            throw new IndexOutOfBoundsException(error_message);
        }
        return (T) collection[i];
    }

    public int length() {
        return index;
    }

    public void printCollection() {
        for (int i = 0; i < index; i++) {
            System.out.println(collection[i].toString());
        }
    }
}
