package nl.belastingdienst.h4opgave7;

public class EvenNumberException extends Exception {
    EvenNumberException() {
        super("This number is even.");
    }
}
