package nl.belastingdienst.h5opgave11;

public class Fibo {
    public static void run(int n) {
        for (int k = 0; k < n; k++) {
            System.out.print("" + fibonacci(k) + " ");
        }
        System.out.print("\n");
    }
    private static int fibonacci(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void efficientRun(int n) {
        efficientFibonacci(0, 1, n);
    }
    private static void efficientFibonacci(int a, int b, int n) {
        if (n > 0) {
            System.out.print("" + b + " ");
            efficientFibonacci(b, a + b, n - 1);
        } else {
            System.out.print("\n");
        }
    }

    public static void efficientRun(int start, int n) {
        efficientFibonacci(0, start, n);
    }
    public static void efficientRun(int f1, int f2, int n) {
        efficientFibonacci(f2 - f1, f1, n);
    }

    public static long returnRun(int n){
        return returnRun(1, n);
    }
    public static long returnRun(int start, int n){
        return returnRun(0, start, n);
    }
    public static long returnRun(int f1, int f2, int n){
        return fibonacci(f1, f2, n);
    }
    public static long fibonacci(long a, long b, int n) {
        while (n > 1) {
            b = b + a;
            a = b - a;
            n--;
        }
        return b;
    }

    public static double approximateGoldenRatio(int n) {
        return (double) returnRun(n) / returnRun(n - 1);
    }
}
