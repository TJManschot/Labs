package nl.belastingdienst.jpa.database;

import javax.persistence.EntityManager;

/**
 *
 * @param <E> Entity Type
 * @param <K> Primary Key Type
 */
public abstract class Dao<E, K> {
    protected EntityManager entityManager;
    private final Class<? extends E> currentClass;

    protected Dao(EntityManager entityManager, Class<? extends E> currentClass) {
        this.entityManager = entityManager;
        this.currentClass = currentClass;
    }

    public E find(K primaryKey) {
        return entityManager.find(currentClass, primaryKey);
    }

    public void insert (E e) {
        entityManager.getTransaction().begin();
        entityManager.persist(e);
        entityManager.getTransaction().commit();
    }
}
