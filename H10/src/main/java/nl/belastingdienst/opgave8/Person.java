package nl.belastingdienst.opgave8;

public class Person extends Human {
    private static final int MAX_AGE = 130;

    private final String name;
    private int age;
    private Gender gender;

    public Person() {
        this("", 0, Gender.UNKNOWN);
    }

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String greet() {
        return "Hello, my name is " + this.name + ". Nice to meet you!";
    }

    public void haveBirthday() throws PersonDiedException {
        if (age < MAX_AGE) {
            age++;
        } else {
            throw new PersonDiedException();
        }
    }

    public String toString() {
        return name + " (" + age + ") is " + gender + ".";
    }

    public boolean equals(Object person) {
        return person instanceof Person
                && this.name.equals(((Person) person).getName())
                && (this.age == ((Person) person).getAge())
                && this.gender.equals(((Person) person).getGender());
    }

    public int hashCode() {
        return age * name.hashCode() * gender.hashCode();
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
