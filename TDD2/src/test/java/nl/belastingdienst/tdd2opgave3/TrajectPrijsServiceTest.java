package nl.belastingdienst.tdd2opgave3;

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
        when(mockedTrajectEenhedenNaarPrijsService.getTrajectEenhedenPrijs(eq(0))).thenReturn(10);
        when(mockedTrajectNaarTrajectEenhedenService.getTrajectEenheden(eq("Zwolle"), eq("Nijmegen"))).thenReturn(0);
        when(mockedTrajectNaarTrajectEenhedenService.getTrajectEenheden(eq("Zwolle"), eq("Bielefeld"))).thenThrow(new InvalidLocationException());
    }

    @Test
    void getTrajectPrijs() {
        Assertions.assertEquals(10, target.getTrajectPrijs("Zwolle", "Nijmegen"));
        Assertions.assertThrows(InvalidLocationException.class, () -> target.getTrajectPrijs("Zwolle", "Bielefeld"));
    }
}