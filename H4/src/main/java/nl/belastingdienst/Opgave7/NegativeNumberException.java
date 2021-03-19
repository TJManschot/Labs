package nl.belastingdienst.Opgave7;

public class NegativeNumberException extends Exception {
    NegativeNumberException(){
        super("This number is negative.");
    }
}
