import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountDITest {

    @DisplayName("Deposit amount succesfully")
    //@RepeatedTest(2)
    @ParameterizedTest
    @ValueSource(ints = {100, 400, 800, 1000})
    public void testDeposit(int amount, BankAccount bankaccount) {

        bankaccount.deposit(amount);
        assertEquals(amount,bankaccount.getBalance());
    }
}
