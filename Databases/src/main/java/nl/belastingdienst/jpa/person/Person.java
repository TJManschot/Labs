package nl.belastingdienst.jpa.person;

import javax.persistence.*;

@Entity
public class Person {
    @Id @GeneratedValue
    protected long id;
    protected String name;
    protected int age;

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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person))
            return false;
        Person other = (Person) obj;
        return other.id == this.id;
    }

    public long getId() {
        return id;
    }
}
