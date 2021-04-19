package nl.belastingdienst.h5.opgave3;

public class MathsApp {
    public static void main(String[] args) {
        System.out.println(Maths.greatest(1, 2));
        System.out.println(Maths.greatest(2, 1));
        System.out.println(Maths.greatest(30, -40, 2));
        System.out.println(Maths.greatest(-40, 30, 2));
        System.out.println(Maths.greatest(-40, 2, 30));
        System.out.println(Maths.greatest("Hallo", "Hoi"));
        System.out.println(Maths.greatest("Hoi", "Hallo"));

        System.out.println(Maths.factorial(5));
        System.out.println(Maths.factorial(1));
        System.out.println(Maths.factorial(0));
        System.out.println(Maths.factorial(-1));
    }
}
