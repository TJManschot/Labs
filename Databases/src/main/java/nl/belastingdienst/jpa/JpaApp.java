package nl.belastingdienst.jpa;

import nl.belastingdienst.jpa.person.*;
import nl.belastingdienst.jpa.database.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JpaApp {
    static Logger log = LoggerFactory.getLogger(JpaApp.class);

    public static final EntityManager entityManager =
            Persistence.createEntityManagerFactory("MySQL-jpalabs").createEntityManager();

    public static void main(String[] args) {
        PersonDao<Person> dao = new PersonDao<>(entityManager);

        log.info("Personen aanmaken...");
        Person thomas = new Person().name("Thomas").age(27);
        Person bob = new Person().name("Bob").age(22);

        log.info("Personen in database stoppen...");
        dao.insert(thomas);
        dao.insert(bob);

        System.out.println(dao.find(thomas.getId()).toString());
    }
}
