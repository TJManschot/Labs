package nl.belastingdienst.opgave8;

public class HumanApp {
    public static void main(String[] args) {
        Android android = new Android();

        System.out.println(android.greet());
        android.charge(35);
        System.out.println(android.greet());
        android.charge(100);
        System.out.println(android.greet());

        Teacher teacher = new Teacher("Bram", 35, Gender.MALE);
        System.out.println(teacher.greet());
        Employee employee = new Employee();
        System.out.println(employee.greet());
        Person person = new Person("Thomas", 27, Gender.MALE);
        System.out.println(person.greet());
    }
}
