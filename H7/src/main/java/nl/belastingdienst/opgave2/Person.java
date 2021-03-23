package nl.belastingdienst.opgave2;

public class Person {
    public static int numberOfPossibleGenders = 3;
    public static int MAXIMUM_AGE = 130;

    private String name;
    private int age;
    private Gender gender;

    public Person(String name, int age) {
        this.name = name;
        this.age = age <= MAXIMUM_AGE ? age : MAXIMUM_AGE;
        this.gender = Gender.UNKNOWN;
    }

    public int getAge() {
        return this.age;
    }
    public void haveBirthday() throws Exception {
        if (this.age >= MAXIMUM_AGE) {
            throw new PersonDiedException();
        } else {
            this.age++;
        }
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public Gender getGender() {
        return this.gender;
    }

    public void setName(String name) { this.name = name; }
    public String getName() { return this.name; }
}
