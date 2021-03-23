package nl.belastingdienst.opgave4;

public class SaldoTeLaagException extends RuntimeException {
    public SaldoTeLaagException() {
        super("Het saldo is te laag.");
    }
}
