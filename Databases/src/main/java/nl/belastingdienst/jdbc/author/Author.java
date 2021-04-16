package nl.belastingdienst.jdbc.author;

public class Author {
    private String id;
    private Name name;
    private Address address;
    private double contract;
    private PhoneNumber phoneNumber;

    public Author id(String id) {
        setId(id);
        return this;
    }

    public Author name(Name name) {
        setName(name);
        return this;
    }

    public Author address(Address address) {
        setAddress(address);
        return this;
    }

    public Author contract(double contract) {
        setContract(contract);
        return this;
    }

    public Author phoneNumber(PhoneNumber phoneNumber) {
        setPhoneNumber(phoneNumber);
        return this;
    }

    @Override
    public String toString() {
        return "id           = " + id +
             "\nname         = " + name.toString() +
             "\naddress      = " + address.toString() +
             "\ncontract     = " + contract +
             "\nphone number = " + phoneNumber.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getContract() {
        return contract;
    }

    public void setContract(double contract) {
        this.contract = contract;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
