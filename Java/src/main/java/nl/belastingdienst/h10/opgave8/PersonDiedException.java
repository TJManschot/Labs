package nl.belastingdienst.h10.opgave8;

public class PersonDiedException extends Exception {
    PersonDiedException() {
        super("This person died of old age (over 130).");
    }
}
