package nl.belastingdienst.jpa.person;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity @Inheritance(strategy = InheritanceType.JOINED)
public class Member extends Person {
    private String username;

    public Member() { }

    public Member(String username) {
        this.username = username;
    }
}
