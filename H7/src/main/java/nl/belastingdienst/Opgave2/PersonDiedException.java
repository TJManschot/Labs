package nl.belastingdienst.Opgave2;

public class PersonDiedException extends Exception {
    PersonDiedException() {
        super("This person died of old age (over 130).");
    }
}
