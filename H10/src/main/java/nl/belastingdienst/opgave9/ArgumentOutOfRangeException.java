package nl.belastingdienst.opgave9;

public class ArgumentOutOfRangeException extends RuntimeException {
    ArgumentOutOfRangeException() {
        super("Discount must be between 1 and 30.");
    }
}
