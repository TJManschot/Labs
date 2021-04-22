package nl.belastingdienst.jpa.database;

import nl.belastingdienst.jpa.person.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DaoIT {
    private Dao<Person, Long> target;
    private final EntityManager entityManager =
            Persistence.createEntityManagerFactory("H2-test-jpalabs").createEntityManager();

    @BeforeEach @SuppressWarnings("unchecked")
    void init() {
        target = (Dao<Person, Long>) mock(Dao.class, withSettings()
                .useConstructor(entityManager, Person.class)
                .defaultAnswer(CALLS_REAL_METHODS)
        );
    }

    @Test
    void testFind() {
        Person thomas = new Person().name("Thomas").age(27);
        Person bob = new Person().name("Bob").age(22);
        Person[] expected = new Person[] {thomas, bob};

        entityManager.getTransaction().begin();
        entityManager.persist(thomas);
        entityManager.persist(bob);
        entityManager.getTransaction().commit();
        Person[] actual = {target.find(1L), target.find(2L)};

        assertArrayEquals(expected, actual);
    }

}
