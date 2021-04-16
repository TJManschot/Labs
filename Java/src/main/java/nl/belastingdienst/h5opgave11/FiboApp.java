package nl.belastingdienst.h5opgave11;

public class FiboApp {
    public static void main(String[] args) {
        Fibo.run(46);
        Fibo.efficientRun(46);

        Fibo.efficientRun(4, 6);
        Fibo.efficientRun(4, 5, 6);

        System.out.println(Fibo.returnRun(6));
        System.out.println(Fibo.approximateGoldenRatio(92)); // 92 is the maximum value for longs, use BigDecimal for more
    }
}
