package nl.belastingdienst.opgave3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class TrajectPrijsServiceTest {
    TrajectPrijsService trajectPrijsService = new TrajectPrijsService();

    TrajectEenhedenNaarPrijsService mockedTrajectEenhedenNaarPrijsService = mock(TrajectEenhedenNaarPrijsService.class);
    TrajectNaarTrajectEenhedenService mockedTrajectNaarTrajectEenhedenService = mock(TrajectNaarTrajectEenhedenService.class);

    @BeforeEach
    void init() throws Exception {
        trajectPrijsService.setTrajectEenhedenNaarPrijsService(mockedTrajectEenhedenNaarPrijsService);
        trajectPrijsService.setTrajectNaarTrajectEenhedenService(mockedTrajectNaarTrajectEenhedenService);

        when(mockedTrajectEenhedenNaarPrijsService.getTrajectEenhedenPrijs(0)).thenReturn(10);
        when(mockedTrajectEenhedenNaarPrijsService.getTrajectEenhedenPrijs(-1)).thenThrow(new InvalidLocationException());
        when(mockedTrajectNaarTrajectEenhedenService.getTrajectEenheden("Zwolle", "Nijmegen")).thenReturn(0);
        when(mockedTrajectNaarTrajectEenhedenService.getTrajectEenheden("Zwolle", "Bielefeld")).thenReturn(-1);
    }

    @Test
    void getTrajectPrijs() {
        Assertions.assertEquals(10, trajectPrijsService.getTrajectPrijs("Zwolle", "Nijmegen"));
        Assertions.assertThrows(InvalidLocationException.class, () -> trajectPrijsService.getTrajectPrijs("Zwolle", "Bielefeld"));
    }
}