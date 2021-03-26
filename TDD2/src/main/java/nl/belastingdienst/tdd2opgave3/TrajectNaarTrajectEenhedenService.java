package nl.belastingdienst.tdd2opgave3;

public class TrajectNaarTrajectEenhedenService {
    public int getTrajectEenheden(String van, String naar) throws InvalidLocationException {
        if (van.equals("Bielefeld") || naar.equals("Bielefeld")) {
            throw new InvalidLocationException();
        }
        return 0;
    }
}
