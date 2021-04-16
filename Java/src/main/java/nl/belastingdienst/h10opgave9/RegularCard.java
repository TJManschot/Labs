package nl.belastingdienst.h10opgave9;

public class RegularCard extends Card {
    public RegularCard(int cardID, String name, double credit) {
        super(cardID, name, credit);
    }

    public boolean pay(int amount) {
        if (credit > (double) amount) {
            credit -= amount;
            return true;
        }
        return false;
    }

    public String toString() {
        return name + " (regular member)";
    }
}
