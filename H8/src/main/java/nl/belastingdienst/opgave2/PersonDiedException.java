package nl.belastingdienst.opgave2;

public class PersonDiedException extends Exception {
    PersonDiedException() {
        super("This person died of old age (over 130).");
    }
}
