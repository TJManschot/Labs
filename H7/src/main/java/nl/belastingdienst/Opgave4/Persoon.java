package nl.belastingdienst.Opgave4;

import java.util.HashMap;
import java.util.Map;

public class Persoon {
    public final String naam;
    public HashMap<String, Rekening> rekening;

    public Persoon(String naam){
        this.naam = naam;
        this.rekening = new HashMap<>();
    }

    public void createRekening(Bank bank, String iban) {
        new Rekening(bank, this, iban);
    }
    public void addRekening(Rekening rekening) {
        this.rekening.put(rekening.iban, rekening);
    }
    public Rekening getRekening(String iban) {
        return rekening.get(iban);
    }
}
