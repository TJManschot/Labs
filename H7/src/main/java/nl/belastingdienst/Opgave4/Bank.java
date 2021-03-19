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

    public static void overschrijving(Rekening vanRekening, Rekening naarRekening, Euro bedrag) {
        try {
            vanRekening.neemOp(bedrag);
            naarRekening.stort(bedrag);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Euro totaalDebet() {
        return new Euro(rekening.values().stream().map(Rekening::getSaldo).mapToInt(Euro::getWaarde).sum());
    }

    public void renteOverzicht() {
        for(Rekening r : rekening.values()) {
            System.out.println("Rekening " + r.iban + " krijgt dit jaar " + r.renteOverTijd(1).toString() + " rente.");
        }
    }
}
