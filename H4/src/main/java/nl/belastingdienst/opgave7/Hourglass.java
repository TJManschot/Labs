package nl.belastingdienst.opgave7;

public class Hourglass {
    private final int n;

    public Hourglass(int n) throws Exception {
        if (n % 2 == 0) {
            throw new EvenNumberException();
        }
        if (n < 0) {
            throw new NegativeNumberException();
        }

        this.n = n;

        for (int i = 0; i < n; i++) {
            printHourglassLine(i);
        }
    }

    private void printHourglassLine(int k) {
        if (k % (n - 1) == 0) {                 // Top and bottom
            for (int i = 0; i < n; i++) {
                System.out.print("*");
            }
        } else if (2 * k + 1 < n) {             // Top half
            printWhiteSpace(k);
            System.out.print("*");
            printWhiteSpace(n - 2 * k - 2);
            System.out.print("*");
            printWhiteSpace(k);
        } else if (2 * k + 1 == n) {            // Middle point
            printWhiteSpace(k);
            System.out.print("*");
            printWhiteSpace(k);
            } else {                            // Bottom half
            printWhiteSpace(n - k - 1);
            System.out.print("*");
            printWhiteSpace(2 * k - n);
            System.out.print("*");
            printWhiteSpace(n - k - 1);
        }
        System.out.print("\n");
    }

    private void printWhiteSpace(int k) {
        for (int i = 0; i < k; i++) {
            System.out.print(" ");
        }
    }
}
