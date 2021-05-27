package nl.belastingdienst.resources;

import nl.belastingdienst.model.Contact;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("contacts")
public class ContactsResource {
    List<Contact> contacts = new ArrayList<>(List.of(new Contact("Thomas", 27), new Contact("Bob", 23)));

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contact> get() {
        return contacts;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Contact post(Contact contact) {
        contacts.add(contact);
        return contact;
    }

}
