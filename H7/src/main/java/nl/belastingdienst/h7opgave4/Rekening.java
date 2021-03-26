package nl.belastingdienst.h7opgave4;

public class Rekening {
    public final Persoon houder;
    public final Bank verstrekker;
    public final String iban;

    private final Euro saldo;
    private double rentePercentage;

    public Rekening(Bank verstrekker, Persoon houder, String iban) {
        this.verstrekker = verstrekker;
        this.houder = houder;
        this.iban = iban;

        this.saldo = new Euro(0);
        this.rentePercentage = 0.0;

        houder.addRekening(this);
        verstrekker.addRekening(this);
    }

    public Euro getSaldo() {
        return saldo;
    }
    public void neemOp(Euro bedrag) {
        if (!saldo.isSmallerThan(bedrag)) {
            saldo.subtract(bedrag);
        } else {
            throw new SaldoTeLaagException();
        }
    }
    public void stort(Euro bedrag) {
        saldo.add(bedrag);
    }

    public double getRentePercentage() {
        return rentePercentage;
    }
    public void setRentePercentage(double rentePercentage) {
        this.rentePercentage = rentePercentage;
    }

    public void overschrijving(Rekening naarRekening, Euro bedrag) {
        Bank.overschrijving(this, naarRekening, bedrag);
    }
    public Euro renteOverTijd(int jaren) {
        Euro result = new Euro(saldo.getWaarde());
        result.multiply(Math.pow(1.0 + rentePercentage, jaren));
        result.subtract(saldo);
        return result;
    }
}
