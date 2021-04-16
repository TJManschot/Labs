package nl.belastingdienst.h11opgave5;

public class PersonApp {
    public static void main(String[] args) {
        Person thomas = new Person();
        Person bram = new Person();

        thomas.addHistory("Thomas is geboren.");
        thomas.addHistory("Thomas eet een boterham.");
        thomas.addHistory("Thomas zit thuis.");
        bram.addHistory("Bram is geboren.");
        bram.addHistory("Bram zit thuis.");
        bram.addHistory("Bram eet een boterham.");

        thomas.printHistory();
        bram.printHistory();

        thomas.createSubHuman();
    }
}
