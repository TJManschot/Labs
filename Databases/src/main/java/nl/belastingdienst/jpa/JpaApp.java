package nl.belastingdienst.jpa;

import nl.belastingdienst.jpa.person.*;
import nl.belastingdienst.jpa.database.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JpaApp {
    public static final EntityManager entityManager =
            Persistence.createEntityManagerFactory("MySQL-jpalabs").createEntityManager();

    public static void main(String[] args) {
        PersonDao dao = new PersonDao(entityManager);

        Person thomas = new Person().name("Thomas").age(27);
        Person bob = new Person().name("Bob").age(22);

        dao.insert(thomas);
        dao.insert(bob);

        System.out.println(dao.find(thomas.getId()).toString());
    }
}
