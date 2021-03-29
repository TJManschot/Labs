package nl.belastingdienst.tdd1opgave7;

import java.util.Arrays;

public class StringCalculator {
    public int add(String input){
        String delimiter = "[,\n]";
        if (input.startsWith("//")) {
            delimiter = input.substring(2,3);
        }
        return Arrays.stream(input.split(delimiter)).map(String::strip).filter((String s) -> !s.equals("") && !s.contains("/")).filter((String s) -> { if(!s.contains("-")) return true; else throw new NumberFormatException("Negatives not allowed! You passed " + s + "."); }).mapToInt(Integer::parseInt).sum();
    }
}
