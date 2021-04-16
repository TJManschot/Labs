package nl.belastingdienst.h10opgave9;

public class ClubApp {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();

        userInterface.add(new RegularCard(0, "Thomas", 100.0));
        userInterface.add(new GoldCard(0, "Bram", 10_000.0, 30));
        userInterface.add(new RegularCard(0, "David", 200.0));
        userInterface.add(new RegularCard(0, "Luc", 500.0));

        System.out.println("Hier volgt een lijst met leden.");
        userInterface.printCards();

        System.out.println("\nHier volgt een lijst met VIPs.");
        userInterface.printGoldCards();

        System.out.println("\nHier volgt een lijst met proleten.");
        userInterface.printRegularCards();

    }
}
