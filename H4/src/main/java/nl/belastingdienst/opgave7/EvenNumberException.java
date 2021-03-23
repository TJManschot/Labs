package nl.belastingdienst.opgave7;

public class EvenNumberException extends Exception {
    EvenNumberException() {
        super("This number is even.");
    }
}
