package nl.belastingdienst.h13opgave5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyIntCollectionTest {
    MyIntCollection<Integer> myIntCollection = new MyIntCollection<>();
    private final int COLLECTION_SIZE = 17;

    @BeforeEach
    void init() {
        for (int i = 0; i < COLLECTION_SIZE; i++) {
            myIntCollection.add(100 - i);
        }
    }

    @Test
    void length() {
        assertEquals(COLLECTION_SIZE, myIntCollection.length());
    }

    @Test
    void printColelction() {
        myIntCollection.printCollection();
    }
}