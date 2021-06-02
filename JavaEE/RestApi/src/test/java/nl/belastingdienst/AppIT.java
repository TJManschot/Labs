package nl.belastingdienst;

import nl.belastingdienst.model.Contact;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import java.net.URL;

import static javax.ws.rs.client.Entity.entity;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static nl.belastingdienst.Util.pomDependency;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Arquillian.class)
public class AppIT {
    @ArquillianResource
    private URL deploymentURL;
    private String contactsResourcePath;

    @Before
    public void setup() { contactsResourcePath = deploymentURL + "api/contacts"; }

    @Deployment
    public static Archive<?> createDeployment() {
        WebArchive warEmpty = ShrinkWrap.create(WebArchive.class, "AppIT.war");
        WebArchive warFilled = warEmpty
                .addPackages(true, App.class.getPackage())
                .addAsLibraries(pomDependency("org.apache.logging.log4j", "log4j-slf4j-impl"))
                .addAsWebInfResource("test-beans.xml", "beans.xml");

        System.out.println(warFilled.toString(true));

        return warFilled;
    }

    @Test
    public void whenContactIsPostedICanGetIt() {
        Client httpClient = ClientBuilder.newClient();

        Contact c = new Contact("Thomas", 27);

        String postedContact = httpClient
                .target(contactsResourcePath)
                .request()
                .post(entity(c, APPLICATION_JSON), String.class);

        assertThat(contactsResourcePath, containsString("AppIT/api/contacts"));
        assertThat(postedContact, containsString("27"));
        assertThat(postedContact, containsString("Thomas"));
    }

}