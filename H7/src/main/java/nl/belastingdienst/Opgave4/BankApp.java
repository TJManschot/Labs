package nl.belastingdienst.Opgave4;

import java.util.HashMap;

// Stuurt de banken aan
public class BankApp {
    public static void main(String[] args){
        HashMap<String, Persoon> persoon = new HashMap<>();
        HashMap<String, Bank> bank = new HashMap<>();

        bank.put("ING", new Bank("ING"));

        persoon.put("Thomas", new Persoon("Thomas"));
        persoon.put("Bram", new Persoon("Bram"));

        bank.get("ING").createRekening(persoon.get("Thomas"), "000");
        bank.get("ING").createRekening(persoon.get("Bram"), "111");

        bank.get("ING").rekening.get("000").setRentePercentage(0.03);
        bank.get("ING").rekening.get("111").setRentePercentage(0.05);

        bank.get("ING").rekening.get("000").stort(10000);
        Bank.overschrijving(bank.get("ING").rekening.get("000"),bank.get("ING").rekening.get("111"), 4000);
        Bank.overschrijving(bank.get("ING").rekening.get("111"),bank.get("ING").rekening.get("000"), 7500);

        System.out.print(bank.get("ING").rekening.get("000").saldoToString());
        System.out.print(bank.get("ING").rekening.get("111").saldoToString());

        System.out.print("De ING heeft in totaal " + Bank.valutaToString(bank.get("ING").getTotalInBank()) + ".\n");

        bank.get("ING").renteOverzicht();
        System.out.println("Thomas krijgt in 10 jaar " + Bank.valutaToString(bank.get("ING").rekening.get("000").calculateInterest(10) - bank.get("ING").rekening.get("000").getSaldo()) + " aan rente.");
    }
}