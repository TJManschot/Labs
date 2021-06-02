package nl.belastingdienst.database.contact;

import nl.belastingdienst.model.Contact;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class ContactDaoDatabase implements ContactDao {

    @PersistenceContext
    private EntityManager em;

    public List<Contact> get() {
        return em
                .createQuery("SELECT c FROM Contact c", Contact.class)
                .getResultList();
    }

    public Optional<Contact> getById(Long id) {
        return Optional.of(em.find(Contact.class, id));
    }

    public Contact add(Contact c) {
        em.persist(c);
        return c;
    }
}
