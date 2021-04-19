package nl.belastingdienst.h7.opgave4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankTest {
    Bank bank = new Bank("BANK");
    Persoon persoon = new Persoon("PERSOON");

    @BeforeEach
    void init() {
        bank.createRekening(persoon, "1");
        bank.createRekening(persoon, "2");

        bank.getRekening("1").stort(new Euro(100_00));
        bank.getRekening("2").stort(new Euro(860_00));
        bank.getRekening("2").stort(new Euro(40_00));
    }

    @Test
    void testOverschrijving() {
        Bank.overschrijving(bank.getRekening("1"), bank.getRekening("2"), new Euro(150_00));
        Bank.overschrijving(bank.getRekening("2"), bank.getRekening("1"), new Euro(150_00));

        assertEquals(250_00, bank.getRekening("1").getSaldo().getWaarde());
        assertEquals(750_00, bank.getRekening("2").getSaldo().getWaarde());
    }

    @Test
    void testTotaalDebet() {
        assertEquals(1000_00, bank.totaalDebet().getWaarde());
    }
}