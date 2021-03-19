package nl.belastingdienst.Opgave6;

import java.util.Scanner;

public class VectorCalculus {
    public static long[] trivialEmbedding(long[] v) {
        long[] result = new long[2 * v.length];
        System.arraycopy(v, 0, result, 0, v.length);
        return result;
    }

    public static long[] scalarMultiplication(long[] v, long m) {
        long[] w = new long[v.length];
        System.arraycopy(v, 0, w, 0, v.length);

        for (int i = 0; i < v.length; i++) {
            w[i] = m * w[i];
        }
        return w;
    }

    public static void printVector(long[] v) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(v[0]);
        if (v.length > 1) {
            for (int i = 1; i < v.length; i++) {
                sb.append(", ");
                sb.append(v[i]);
            }
        }
        sb.append(")");
        System.out.println(sb);
    }

    public static long[] fibonacciVector(int n) {
        long[] fibonacciSequence = new long[n];

        fibonacciSequence[0] = 1;
        fibonacciSequence[1] = 1;

        for (int i = 2; i < n; i++) {
            fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
        }

        return fibonacciSequence;
    }

    public static long[] readVector() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter your vector (components must be separated by \", \"): ");
        String inputString = in.nextLine();

        String[] vectorString = inputString.split(", ");
        long[] vector = new long[vectorString.length];

        for(int i = 0; i < vectorString.length; i++) {
            vector[i] = Long.parseLong(vectorString[i]);
        }
        return vector;
    }


}
