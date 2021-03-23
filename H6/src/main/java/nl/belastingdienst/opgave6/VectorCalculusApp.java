package nl.belastingdienst.opgave6;

import java.util.Arrays;

public class VectorCalculusApp {
    public static void main(String[] args) {
        long[] vector = {1L, 10L, 100L, 1000L};

        VectorCalculus.printVector(vector);
        VectorCalculus.printVector(VectorCalculus.trivialEmbedding(vector));
        VectorCalculus.printVector(VectorCalculus.scalarMultiplication(vector, 2));
        VectorCalculus.printVector(vector);

        VectorCalculus.printVector(VectorCalculus.fibonacciVector(6));

        vector = VectorCalculus.readVector();
        VectorCalculus.printVector(vector);
        System.out.println("The sum of its components is " + Arrays.stream(vector).sum() + ".");
    }
}
