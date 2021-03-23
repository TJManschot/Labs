package nl.belastingdienst.opgave3;

public class TrajectEenhedenNaarPrijsService {
    public int getTrajectEenhedenPrijs(int aantalTrajectEenheden) throws InvalidLocationException {
        try {
            return aantalTrajectEenheden;
        } catch (InvalidLocationException e) {
            throw e;
        }
    }
}
