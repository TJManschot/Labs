package nl.belastingdienst.jdbc.author;

public class Name {
    private String firstName = "UNKNOWN";
    private String lastName = "UNKNOWN";

    public Name firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public Name lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
