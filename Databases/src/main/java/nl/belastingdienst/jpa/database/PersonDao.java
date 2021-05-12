package nl.belastingdienst.jpa.database;

import nl.belastingdienst.jpa.person.*;

import javax.persistence.EntityManager;

public class PersonDao<E extends Person> extends Dao<Person, Long> {

    public PersonDao(EntityManager entityManager) {
        super(entityManager, Person.class);
    }

    protected PersonDao(EntityManager entityManager, Class<? extends Person> currentClass) {
        super(entityManager, currentClass);
    }

//    @SuppressWarnings("unchecked")
//    public E findByName(String name) {
//        return (E) entityManager.createQuery("SELECT e FROM " + this.getClass(). + " e WHERE name =: e.name")
//                .getSingleResult();
//    }
}
