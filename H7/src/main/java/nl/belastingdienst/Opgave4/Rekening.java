package nl.belastingdienst.Opgave4;

public class Rekening {
    private Persoon houder;
    private final Bank verstrekker;
    public final String iban;

    private int saldo;
    private double rentePercentage;

    public Rekening(Bank verstrekker, Persoon houder, String iban) {
        this.verstrekker = verstrekker;
        this.houder = houder;
        this.iban = iban;

        this.saldo = 0;
        this.rentePercentage = 0.0;
    }

    public Persoon getHouder(){
        return this.houder;
    }

    public boolean neemOp(int amount) {
        if (this.saldo > amount) {
            this.saldo -= amount;
            return true;
        } else {
            return false;
        }
    }
    public void stort(int amount) {
        this.saldo += amount;
    }
    public int getSaldo() {
        return this.saldo;
    }
    public StringBuilder saldoToString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Het saldo op ");
        sb.append(this.iban);
        sb.append(" van ");
        sb.append(this.houder.naam);
        sb.append(" is momenteel ");
        sb.append(Bank.valutaToString(this.saldo));
        sb.append(".\n");

        return sb;
    }

    public double getRentePercentage() {
        return this.rentePercentage;
    }
    public void setRentePercentage(double rentePercentage) {
        this.rentePercentage = rentePercentage;
    }
    public int calculateInterest(int n) {
        if (n == 1) {
            return (int) ((1 + rentePercentage) * this.saldo);
        } else {
            return (int) ((1 + rentePercentage) * calculateInterest(n-1));
        }
    }
}
