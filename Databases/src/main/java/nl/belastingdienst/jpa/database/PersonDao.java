package nl.belastingdienst.jpa.database;

import nl.belastingdienst.jpa.person.*;

import javax.persistence.EntityManager;

public class PersonDao extends Dao<Person, Long> {

    public PersonDao(EntityManager entityManager) {
        super(entityManager, Person.class);
    }

    protected PersonDao(EntityManager entityManager, Class<? extends Person> currentClass) {
        super(entityManager, currentClass);
    }
//
//    public Person findByName(String name) {
//        return entityManager.find(currentClass, name);
//    }
}
