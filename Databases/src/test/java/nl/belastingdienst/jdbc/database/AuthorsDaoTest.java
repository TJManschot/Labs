package nl.belastingdienst.jdbc.database;

import nl.belastingdienst.jdbc.author.Address;
import nl.belastingdienst.jdbc.author.Author;
import nl.belastingdienst.jdbc.author.Name;
import nl.belastingdienst.jdbc.author.PhoneNumber;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import static java.util.stream.Collectors.joining;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AuthorsDaoTest {
    @InjectMocks
    private AuthorsDao target;

    @BeforeAll
    static void beforeAll() throws SQLException {
        InputStream in = AuthorsDaoTest.class
                .getClassLoader()
                .getResourceAsStream("AuthorsTest.sql");

        if (in == null)
            throw new NullPointerException("Input file not found.");

        String script = new BufferedReader(new InputStreamReader(in))
                .lines()
                .collect(joining());

        new DatabaseConnector()
                .getConnection()
                .createStatement()
                .execute(script);
    }

    @Test
    void instance() {
        assertThat(target).isInstanceOf(AuthorsDao.class);
        assertThat(target).isNotNull();
        assertEquals("authors", target.table.toLowerCase(Locale.ROOT));
    }

    @Test
    void testSearchByName() {
        Name name = new Name().firstName("Thomas").lastName("Test-Engine");
        Address address = new Address().address("").city("").state("").zip(0);
        PhoneNumber phoneNumber = new PhoneNumber().phoneNumber("");

        Author expected = new Author().address(address).name(name).phoneNumber(phoneNumber).id("1").contract(0.0);
        List<Author> authorList = target.searchByName(name);

        assertEquals(expected, authorList.get(0));
    }
}