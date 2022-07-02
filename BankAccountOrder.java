import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankAccountOrder {

    static BankAccount bankaccount = new BankAccount(0,0);
    @Test
    @Order(2)
    public void testWithdraw() {
        bankaccount.withdraw(300);
        assertEquals(200, bankaccount.getBalance());
    }
    @Test
    @Order(1)
    public void testDeposit() {
        bankaccount.deposit(500);
        assertEquals(500, bankaccount.getBalance());
    }
}
