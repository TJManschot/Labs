package nl.belastingdienst.resources;

import nl.belastingdienst.database.contact.ContactDao;
import nl.belastingdienst.model.Contact;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("contacts")
public class ContactsResource implements JsonResource{

    @Inject
    Logger log;

    @Inject
    ContactDao dao;

    @GET
    public List<Contact> get() {
        log.info("Fetching contacts ...");
        return dao.get();
    }

    @POST
    public Contact post(Contact contact) {
        log.info("Adding contact ...");
        dao.add(contact);
        log.info("Contact added!");
        return contact;
    }

}
