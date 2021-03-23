package nl.belastingdienst.opgave2;

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
