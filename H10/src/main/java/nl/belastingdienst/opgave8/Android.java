package nl.belastingdienst.opgave8;

public class Android extends Human implements Chargeable {
    public static final int maxEnergy = 100;
    public static final int minEnergy =   0;
    private int energyLevel = minEnergy;

    @Override
    public String greet() {
        return "I'm only half human, but human still ..." +
                "\n My energy level is " + 100*(energyLevel-minEnergy)/(maxEnergy-minEnergy) + "%.";
    }

    public int charge(int amount) {
        energyLevel += amount;
        energyLevel = Math.max(minEnergy, energyLevel);
        energyLevel = Math.min(maxEnergy, energyLevel);
        return energyLevel;
    }
}
