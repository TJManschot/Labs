package nl.belastingdienst.model;

public class Contact {
    private String name;
    private int age;

    @SuppressWarnings("unused")
    public Contact() {}

    public Contact(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
