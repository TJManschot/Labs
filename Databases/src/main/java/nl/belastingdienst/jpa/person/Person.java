package nl.belastingdienst.jpa.person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {
    @Id @GeneratedValue
    private long id;
    private String name;
    private int age;

    public Person name(String name) {
        this.name = name;
        return this;
    }
    public Person age(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }

    public long getId() {
        return id;
    }
}
