package nl.belastingdienst.h7.opgave2;

public class PersonDiedException extends Exception {
    public PersonDiedException() {
        super("This person died of old age (over 130).");
    }
}
