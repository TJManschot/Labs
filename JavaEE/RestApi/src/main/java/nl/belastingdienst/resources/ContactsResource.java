package nl.belastingdienst.resources;

import nl.belastingdienst.model.Contact;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("contacts")
public class ContactsResource implements JsonResource{

    @Inject
    Logger log;

    List<Contact> contacts = new ArrayList<>(List.of(
            new Contact("Thomas", 27),
            new Contact("Bob", 23)
    ));

    @GET
    public List<Contact> get() {
        log.info("Fetching contacts ...");
        return contacts;
    }

    @POST
    public Contact post(Contact contact) {
        log.info("Adding contact ...");
        contacts.add(contact);
        log.info("Contact added!");
        return contact;
    }

}
