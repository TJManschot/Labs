package nl.belastingdienst.Opgave4;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    public final String naam;
    HashMap<String, Rekening> rekening = new HashMap<>();

    public Bank(String naam) {
        this.naam = naam;
    }

    public void createRekening(Persoon houder, String iban) {
        rekening.put(iban, new Rekening(this, houder, iban));
    }

    public static String valutaToString(int bedrag) {
        if (bedrag % 100 >= 10) {
            return "€" + bedrag / 100 + "," + bedrag % 100;
        } else {
            return "€" + bedrag / 100 + ",0" + bedrag % 100;
        }
    }

    public static boolean overschrijving(Rekening vanRekening, Rekening naarRekening, int bedrag) {
        if (vanRekening.neemOp(bedrag)) {
            naarRekening.stort(bedrag);
            return true;
        } else {
            System.out.println("Dit bedrag kan niet overgeschreven worden doordat het saldo van de herkomstrekening te laag is.");
            return false;
        }
    }

    public int getTotalInBank() {
        return rekening.values().stream().mapToInt(Rekening::getSaldo).sum();
    }

    public void renteOverzicht() {
        for (Map.Entry r : rekening.entrySet()) {
            System.out.println("Rekening " + rekening.get(r.getKey()).iban + " krijgt dit jaar "
                    + valutaToString(rekening.get(r.getKey()).calculateInterest(1) - rekening.get(r.getKey()).getSaldo()) + " rente.");
        }
    }
}
