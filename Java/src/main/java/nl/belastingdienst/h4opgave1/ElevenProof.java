package nl.belastingdienst.h4opgave1;

public class ElevenProof {
    public static final int MAX_NUMBER_OF_DIGITS = 9;

    public static void checkValidity(int accountNumber){
        int weighedDigitSum = 0;
        for(int i = 1; i <= MAX_NUMBER_OF_DIGITS; i++) {
            weighedDigitSum += i * (accountNumber % Math.pow(10, i) / Math.pow(10, i - 1));
        }

        if (accountNumber >= Math.pow(10, MAX_NUMBER_OF_DIGITS)){
            throw new IllegalArgumentException("Account number too large.");
        } else if (weighedDigitSum % 11 != 0) {
            throw new IllegalArgumentException("Account number not valid.");
        }
    }
}
