import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CalculateMockitoTest {
    @Mock
    BankAccount bankaccount;
    @BeforeEach
    public void setupMock() {
        Mockito.when(bankaccount.getBalance()).thenReturn(2.0);
    }

    @Test
    public void testMethod() {
        assertEquals(bankaccount.getBalance(),2.0);
    }
}
