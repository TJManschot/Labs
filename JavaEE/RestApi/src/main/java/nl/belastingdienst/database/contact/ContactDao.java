package nl.belastingdienst.database.contact;

import nl.belastingdienst.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactDao {
    List<Contact> get();

    Optional<Contact> getById(Long id);

    Contact add(Contact c);
}
