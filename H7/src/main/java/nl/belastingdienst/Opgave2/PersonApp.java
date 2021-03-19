package nl.belastingdienst.Opgave2;

public class PersonApp {
    public static void main(String[] args) {
        Person thomas = new Person("Thomas", 27);
        thomas.setGender(Gender.MALE);

        while (true) {
            try {
                thomas.haveBirthday();
                System.out.println(thomas.getName() + " is a " + thomas.getAge() + " year old "
                        + thomas.getGender().toString().toLowerCase() + ".");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

}
