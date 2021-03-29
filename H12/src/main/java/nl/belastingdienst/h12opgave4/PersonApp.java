package nl.belastingdienst.h12opgave4;

import java.lang.reflect.Method;

public class PersonApp {
    public static void main(String[] args) {
        Person thomas = new Person();
        Person bram = new Person();

        thomas.addHistory("Thomas is geboren.");
        thomas.addHistory("Thomas eet een boterham.");
        thomas.addHistory("Thomas zit thuis.");
        bram.addHistory("Bram is geboren.");
        bram.addHistory("Bram zit thuis.");
        bram.addHistory("Bram eet een boterham.");

        thomas.printHistory();
        bram.printHistory();

        thomas.createSubHuman();

        for(Method m : Person.class.getMethods()) {
            if (m.isAnnotationPresent(Author.class)) {
                System.out.println(m.getAnnotation(Author.class).value());
            }
        }
    }
}
