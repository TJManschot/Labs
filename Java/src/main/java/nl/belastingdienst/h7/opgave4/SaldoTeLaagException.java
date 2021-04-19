package nl.belastingdienst.h7.opgave4;

public class SaldoTeLaagException extends RuntimeException {
    public SaldoTeLaagException() {
        super("Het saldo is te laag.");
    }
}
