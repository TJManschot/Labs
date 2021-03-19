package nl.belastingdienst.Opgave7;

import java.util.Scanner;

public class HourglassApp {
    public static void main(String[] args) {
        int failedAttempts = 0;
        int maxFailedAttempts = 3;

        Scanner in = new Scanner(System.in);
        int n;

        while (failedAttempts < maxFailedAttempts) {
            System.out.println("Please enter an odd number larger than 0.");
            try {
                n = Integer.parseInt(in.nextLine());
            } catch (RuntimeException e) {
                System.out.println("This is not an integer.");
                failedAttempts++;
                continue;
            }

            try {
                Hourglass hourglass = new Hourglass(n);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                failedAttempts++;
            }
        }

        if (failedAttempts == maxFailedAttempts) {
            System.out.println("How hard can it be, mate?");
        }
    }
}
