package nl.belastingdienst.opgave3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TrajectPrijsServiceTest {
    @Mock
    TrajectEenhedenNaarPrijsService mockedTrajectEenhedenNaarPrijsService;
    @Mock
    TrajectNaarTrajectEenhedenService mockedTrajectNaarTrajectEenhedenService;
    @InjectMocks
    private TrajectPrijsService target;

    @BeforeEach
    void init() {
        when(mockedTrajectEenhedenNaarPrijsService.getTrajectEenhedenPrijs(0)).thenReturn(10);
        when(mockedTrajectEenhedenNaarPrijsService.getTrajectEenhedenPrijs(-1)).thenThrow(new InvalidLocationException());
        when(mockedTrajectNaarTrajectEenhedenService.getTrajectEenheden("Zwolle", "Nijmegen")).thenReturn(0);
        when(mockedTrajectNaarTrajectEenhedenService.getTrajectEenheden("Zwolle", "Bielefeld")).thenReturn(-1);
    }

    @Test
    void getTrajectPrijs() {
        Assertions.assertEquals(10, target.getTrajectPrijs("Zwolle", "Nijmegen"));
        Assertions.assertThrows(InvalidLocationException.class, () -> target.getTrajectPrijs("Zwolle", "Bielefeld"));
    }
}