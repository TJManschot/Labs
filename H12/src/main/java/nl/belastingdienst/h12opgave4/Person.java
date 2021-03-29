package nl.belastingdienst.h12opgave4;

import java.util.ArrayList;

public class Person extends Human {
    private final ArrayList<HistoryRecord> historyRecords = new ArrayList<>();

    public String greet() {
        return "Good morning!";
    }

    @NestedClass
    private class HistoryRecord {
        private final String description;

        public HistoryRecord(String description) {
            this.description = description;
        }

        public String toString() {
            return description;
        }
    }

    @Author("Thomas")
    public void addHistory(String description) {
        historyRecords.add(new HistoryRecord(description));
    }

    @Author("Thomas")
    public void printHistory() {
        for(HistoryRecord hr : historyRecords) {
            System.out.println(hr.toString());
        }
    }

    @Author
    public void createSubHuman() {
        Human subHuman = new Human() {
            public String greet() {
                return "Sub is the best.";
            }
        };
        System.out.println(subHuman.greet());
    }
}
