package nl.belastingdienst.h7.opgave4;

import java.util.HashMap;

public class BankApp {
    public static void main(String[] args){
        HashMap<String, Bank> bank = new HashMap<>();
        HashMap<String, Persoon> persoon = new HashMap<>();

        init(bank, persoon);

        bank.get("ING").createRekening(persoon.get("Thomas"), "00_00");
        bank.get("ING").createRekening(persoon.get("Bram"), "00_01");

        persoon.get("Thomas").createRekening(bank.get("RaboBank"), "01_00");
        persoon.get("Thomas").createRekening(bank.get("ABN AMRO"), "02_00");
        persoon.get("Bram").createRekening(bank.get("ABN AMRO"), "02_01");

        /*
            Bank        Rekening    Persoon
            ING         00_00       Thomas
            ING         00_01       Bram
            RaboBank    01_00       Thomas
            ABN AMRO    02_00       Thomas
            ABN AMRO    02_01       Bram
         */

        persoon.get("Thomas").getRekening("01_00").stort(new Euro(80_00));
        bank.get("ING").getRekening("00_01").stort(new Euro(20_00));

        bank.get("RaboBank").getRekening("01_00").setRentePercentage(0.03);
        persoon.get("Bram").getRekening("00_01").setRentePercentage(0.05);

        persoon.get("Bram").getRekening("00_01").overschrijving(persoon.get("Thomas").getRekening("01_00"), new Euro(40_00));
        Bank.overschrijving(persoon.get("Thomas").getRekening("01_00"), persoon.get("Bram").getRekening("00_01"), new Euro(40_00));

        System.out.println("Thomas heeft op rekening 01_00 " + persoon.get("Thomas").getRekening("01_00").getSaldo().toString() + " staan.");
        System.out.println("Bram heeft op rekening 00_01 " + persoon.get("Bram").getRekening("00_01").getSaldo().toString() + " staan.");

        System.out.print("De ING heeft in totaal " + bank.get("ING").totaalDebet().toString() + " uit staan.\n");

        bank.get("ING").renteOverzicht();
        bank.get("RaboBank").renteOverzicht();
        bank.get("ABN AMRO").renteOverzicht();
        System.out.println("Thomas krijgt in 10 jaar " + persoon.get("Thomas").getRekening("01_00").renteOverTijd(10).toString() + " aan rente op rekening 01_00.");
    }
    private static void init(HashMap<String, Bank> bank, HashMap<String, Persoon> persoon) {
        Bank ing_00 = new Bank("ING");
        Bank rabobank_01 = new Bank("RaboBank");
        Bank abn_amro_02 = new Bank("ABN AMRO");

        Persoon thomas = new Persoon("Thomas");
        Persoon bram = new Persoon("Bram");

        bank.put(ing_00.naam, ing_00);
        bank.put(rabobank_01.naam, rabobank_01);
        bank.put(abn_amro_02.naam, abn_amro_02);

        persoon.put(thomas.naam, thomas);
        persoon.put(bram.naam, bram);
    }
}