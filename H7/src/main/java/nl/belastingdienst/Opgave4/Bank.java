package nl.belastingdienst.Opgave4;

import java.util.HashMap;

public class Bank {
    public final String naam;
    public HashMap<String, Rekening> rekening = new HashMap<>();

    public Bank(String naam) {
        this.naam = naam;
    }

    public void createRekening(Persoon houder, String iban) {
        new Rekening(this, houder, iban);
    }
    public void addRekening(Rekening rekening) {
        this.rekening.put(rekening.iban, rekening);
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
            System.out.println("Rekening " + r.iban + " van " + r.houder.naam + " bij de " + r.verstrekker.naam
                    + " krijgt dit jaar " + r.renteOverTijd(1).toString() + " rente.");
        }
    }
}
