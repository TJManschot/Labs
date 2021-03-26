package nl.belastingdienst.h10opgave8;

public class Employee extends Person {
    public Employee() {
        super();
    }


    @Override
    public String greet() {
        return "I'm tired of working. This is inhuman!";
    }
}
