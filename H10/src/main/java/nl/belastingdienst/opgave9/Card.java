package nl.belastingdienst.opgave9;

abstract class Card {
    public final int cardID;
    protected String name;
    protected String address;
    protected String city;
    protected double credit;

    protected Card(int cardID, String name, String address, String city, double credit) {
        this.cardID = cardID;
        this.name = name;
        this.address = address;
        this.city = city;
        this.credit = credit;
    }

    protected Card(int cardID, String name, double credit) {
        this(cardID, name, "", "", credit);
    }

    abstract boolean pay(int amount);
}
