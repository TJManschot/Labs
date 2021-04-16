package nl.belastingdienst.h10opgave9;

public class GoldCard extends Card {
    private int discount;

    public GoldCard(int cardID, String name, double credit, int discount) {
        super(cardID, name, credit);
        if (1 <= discount && discount <= 30) {
            this.discount = discount;
        } else {
            throw new ArgumentOutOfRangeException();
        }
    }

    public boolean pay(int amount) {
        if (credit > amount * (100 - discount) / 100.0) {
            credit -= amount * (100 - discount) / 100.0;
            return true;
        }
        return false;
    }

    public String toString() {
        return name + " (gold member)";
    }
}
