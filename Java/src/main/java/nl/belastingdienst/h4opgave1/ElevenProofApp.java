package nl.belastingdienst.h4opgave1;

import java.util.Scanner;

public class ElevenProofApp {
    public static void main(String[] args) {
        System.out.print("Enter account number: ");
        Scanner in = new Scanner(System.in);

        try {
            ElevenProof.checkValidity(Integer.parseInt(in.next()));
            System.out.println("That's valid! Have a nice day!");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
