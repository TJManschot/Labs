package nl.belastingdienst.h4opgave7;

public class NegativeNumberException extends Exception {
    NegativeNumberException(){
        super("This number is negative.");
    }
}
