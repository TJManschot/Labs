package nl.belastingdienst.tdd1opgave7;

import java.util.ArrayList;
import java.util.Arrays;

public class StringCalculator {
    public final static int MAX_INT = 1000;

    public int add(String input) {
        String delimiter = parseDelimiter(input);

        ArrayList<String> negatives = new ArrayList<>();
        int sum = Arrays.stream(input.split(delimiter))
                .map(String::strip)
                .filter((String s) -> {
                    if (!s.contains("-")) return !s.isEmpty() && !s.contains("/");
                    else negatives.add(s);
                    return false;
                })
                .mapToInt(Integer::parseInt)
                .filter(n -> n <= MAX_INT)
                .sum();

        makeException(negatives);
        return sum;
    }

    private String parseDelimiter(String input) {
        StringBuilder sb = new StringBuilder();

        if (input.startsWith("//")) {
            sb.append(input.charAt(2));
        } else {
            sb.append("[,\n]");
        }

        return sb.toString();
    }

    private void makeException(ArrayList<String> negatives) {
        if (!negatives.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Negatives not allowed! You passed ");
            sb.append(negatives.get(0));
            for (int i = 1; i < negatives.size(); i++) {
                sb.append(", ");
                sb.append(negatives.get(i));
            }
            sb.append(".");
            throw new NumberFormatException(sb.toString());
        }
    }
}
