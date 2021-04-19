package nl.belastingdienst.h4.opgave7;

public class EvenNumberException extends Exception {
    EvenNumberException() {
        super("This number is even.");
    }
}
