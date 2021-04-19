package nl.belastingdienst.jdbc.author;

public class PhoneNumber {
    private String phoneNumber = "UNKNOWN";

    public PhoneNumber phoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        return this;
    }

    @Override
    public String toString() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        PhoneNumber other = (PhoneNumber) obj;

        return other.getPhoneNumber().equals(this.phoneNumber);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
