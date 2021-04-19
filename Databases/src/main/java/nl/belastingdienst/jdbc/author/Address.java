package nl.belastingdienst.jdbc.author;

public class Address {
    private String address= "UNKNOWN";
    private String city = "UNKNOWN";
    private String state = "UNKNOWN";
    private int zip;

    public Address address(String address) {
        setAddress(address);
        return this;
    }

    public Address city (String city) {
        setCity(city);
        return this;
    }

    public Address state(String state) {
        setState(state);
        return this;
    }

    public Address zip(int zip) {
        setZip(zip);
        return this;
    }

    @Override
    public String toString() {
        return address + " " + city + " " + state;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Address))
            return false;

        Address other = (Address) obj;
        return other.getAddress().equals(this.address)
                    && other.getCity().equals(this.city)
                    && other.getState().equals(this.state)
                    && other.getZip() == this.zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }
}
