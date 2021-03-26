package nl.belastingdienst.h7opgave4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RekeningTest {
    Bank bank = new Bank("BANK");
    Persoon persoon = new Persoon("PERSOON");
    Rekening rekening = new Rekening(bank, persoon, "1");

    @BeforeEach
    void init() {
        rekening.setRentePercentage(0.03);

        rekening.neemOp(rekening.getSaldo());
        rekening.stort(new Euro(100_00));
    }

    @Test
    void testNeemOpHappyFlow() {
        rekening.neemOp(new Euro(40_00));

        assertEquals(60_00, rekening.getSaldo().getWaarde());
    }

    @Test
    void testNeemOpUnhappyFlow() {
        assertThrows(SaldoTeLaagException.class, () ->  rekening.neemOp(new Euro(140_00)));
    }

    @Test
    void renteOverTijd() {
        assertEquals(0, rekening.renteOverTijd(0).getWaarde());
        assertEquals(3_00, rekening.renteOverTijd(1).getWaarde());
        assertEquals(6_09, rekening.renteOverTijd(2).getWaarde());
        assertEquals(9_27, rekening.renteOverTijd(3).getWaarde());
        assertEquals(12_55, rekening.renteOverTijd(4).getWaarde());
        assertEquals(15_92, rekening.renteOverTijd(5).getWaarde());
        assertEquals(19_40, rekening.renteOverTijd(6).getWaarde());
        assertEquals(22_98, rekening.renteOverTijd(7).getWaarde());
        assertEquals(26_67, rekening.renteOverTijd(8).getWaarde());
        assertEquals(30_47, rekening.renteOverTijd(9).getWaarde());
    }
}