package nl.belastingdienst.h7opgave2;

import nl.belastingdienst.h7opgave2.Gender;
import nl.belastingdienst.h7opgave2.Person;
import org.junit.jupiter.api.Test;

public class TestPerson {
    @Test
    void testPerson() {
        Person p = new Person("Jan", 45);
        System.out.println(p.getGender());
        p.setGender(Gender.MALE);
        System.out.println(p.getGender());
        try {
            p.haveBirthday(); // person gets one year older
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(p.getAge());
        System.out.println(Person.numberOfPossibleGenders);
    }

}
