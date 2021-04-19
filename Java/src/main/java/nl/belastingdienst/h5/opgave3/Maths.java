package nl.belastingdienst.h5.opgave3;

public class Maths {
    public static int greatest(int a, int b) {
        if (a < b) {
            return b;
        }
        return a;
    }

    public static int greatest(int... list) {
        int greatest = list[0];

        for(int n : list) {
            if(greatest < n) {
                greatest = n;
            }
        }
        return greatest;
    }

    public static String greatest(String a, String b) {
        if (a.length() < b.length()) {
            return b;
        }
        return a;
    }

    public static int factorial(int n) {
        if (n > 0) {
            return n * factorial(n - 1);
        }
        return 1;
    }
}
