package nl.belastingdienst;

public class Contact {
    private final String voornaam;
    private final String achternaam;
    private final String email;

    public Contact(String voornaam, String achternaam, String email) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getNaam() {
        return voornaam + " " + achternaam;
    }

    public String getEmail() {
        return email;
    }
}
