import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("Test BankAccount class")
public class testBankAccount {
    @Test
    @DisplayName("Withdraw 500 successfully")
    public void testWithdraw() {
        BankAccount bankaccount = new BankAccount(500, -1000);
        bankaccount.withdraw(300);
        assertEquals(200,bankaccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 500 succesfully")
    public void testDeposit() {
        BankAccount bankaccount = new BankAccount(400, 0);
        bankaccount.deposit(500);
        assertEquals(900,bankaccount.getBalance());
    }

    @Test
    @DisplayName("Withdraw will become negative")
    public void testWithdraNotStuckAtZero() {
        BankAccount bankaccount = new BankAccount(500, -1000);
        bankaccount.withdraw(800);
        assertNotEquals(0, bankaccount.getBalance());
    }

    @Test
    @DisplayName("Test we can't withdraw below minimum")
    public void testWithdrawBelowMinimum() {
        BankAccount bankaccount = new BankAccount(500, -1000);
        assertThrows(RuntimeException.class, () -> bankaccount.withdraw(2000));
    }

    @Test
    @DisplayName("Test we can't withdraw below minimum without Exception")
    public void testWithdrawBelowMinimumNoException() {
        BankAccount bankaccount = new BankAccount(500, -1000);
        assertAll(() -> bankaccount.deposit(200), () -> bankaccount.withdraw(450));
    }

    @Test
    @DisplayName("Test the time needed for the completion of deposit")
    public void testDepositTimeout() {
        BankAccount bankaccount = new BankAccount(400, 0);
        assertTimeout(Duration.ofNanos(1), () -> bankaccount.deposit(500));
    }
}
