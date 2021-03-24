package nl.belastingdienst.opgave2;

import java.lang.reflect.*;
import java.util.Arrays;

public class PersonApp {
    public static void main(String[] args) {
        Person thomas = new Person("Thomas", 27, Gender.MALE);
        Person anna = new Person("Anna", 25, Gender.FEMALE);
        Person thomas2 = new Person("Thomas", 27, Gender.MALE);
        String hoi = "Hoi";

        System.out.println(thomas.toString());
        System.out.println(anna.toString());

        System.out.println("\nThomas equals himself: " + thomas.equals(thomas2) + ".");
        System.out.println("Thomas equals Anna: " + thomas.equals(anna) + ".");
        System.out.println("Person object equals String: " + thomas.equals(hoi) + ".");

        System.out.println("\nThomas' hash code is " + thomas.hashCode() + ".");
        System.out.println("Anna's hash code is " + anna.hashCode() + ".");

        System.out.println("\nThe Person class contains:");
        printClass(new Person());
    }

    private static void printClass(Object object) {
        Constructor[] constructorList = object.getClass().getDeclaredConstructors();
        Method[] methodList = object.getClass().getDeclaredMethods();
        Field[] fieldList = object.getClass().getDeclaredFields();

        System.out.println("Constructors: ");
        for(Constructor constructor : constructorList) {
            System.out.println(Modifier.toString(constructor.getModifiers()) + " " + constructor.getName() + " " + Arrays.toString(Arrays.stream(constructor.getParameters()).map(Parameter::getType).map(Type::getTypeName).toArray()));
        }

        System.out.println("\nMethods: ");
        for(Method method : methodList) {
            System.out.println(Modifier.toString(method.getModifiers()) + " " + method.getReturnType().getName() + " " + method.getName() + Arrays.toString(Arrays.stream(method.getParameterTypes()).map(Type::getTypeName).toArray()));
        }

        System.out.println("\nFields: ");
        for(Field field : fieldList) {
            System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getName() + " " + field.getName());
        }
    }
}
