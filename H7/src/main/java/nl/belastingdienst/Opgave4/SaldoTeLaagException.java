package nl.belastingdienst.Opgave4;

public class SaldoTeLaagException extends RuntimeException {
    public SaldoTeLaagException() {
        super("Het saldo is te laag.");
    }
}
