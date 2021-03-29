package nl.belastingdienst.tdd1opgave7;

import java.util.Arrays;

public class StringCalculator {
    public int add(String input) {
        if (input.startsWith("//")) {
            return Arrays.stream(input.split(input.substring(2,3))).map(String::strip).filter((String s) -> !s.equals("") && !s.contains("/")).mapToInt(Integer::parseInt).sum();
        }
        return Arrays.stream(input.split("[,\n]")).map(String::strip).filter((String s) -> !s.equals("")).mapToInt(Integer::parseInt).sum();
    }
}
