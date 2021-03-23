package nl.belastingdienst.opgave3;

public class TrajectPrijsService {
    private TrajectNaarTrajectEenhedenService trajectNaarTrajectEenhedenService  = new TrajectNaarTrajectEenhedenService();
    private TrajectEenhedenNaarPrijsService trajectEenhedenNaarPrijsService = new TrajectEenhedenNaarPrijsService();

    public int getTrajectPrijs(String van, String naar) throws InvalidLocationException {
        try {
            return trajectEenhedenNaarPrijsService.getTrajectEenhedenPrijs(trajectNaarTrajectEenhedenService.getTrajectEenheden(van, naar));
        } catch (InvalidLocationException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void setTrajectNaarTrajectEenhedenService(TrajectNaarTrajectEenhedenService trajectNaarTrajectEenhedenService) {
        this.trajectNaarTrajectEenhedenService = trajectNaarTrajectEenhedenService;
    }

    public void setTrajectEenhedenNaarPrijsService(TrajectEenhedenNaarPrijsService trajectEenhedenNaarPrijsService) {
        this.trajectEenhedenNaarPrijsService = trajectEenhedenNaarPrijsService;
    }
}
