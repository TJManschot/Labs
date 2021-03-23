package nl.belastingdienst.opgave7;

public class NegativeNumberException extends Exception {
    NegativeNumberException(){
        super("This number is negative.");
    }
}
