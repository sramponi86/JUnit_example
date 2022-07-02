import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class BankAccountConditionalTest {
    @Test
    @EnabledOnOs({OS.MAC})
    public void testMac() {

    }
    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testWindows() {

    }
    @Test
    @EnabledOnJre(JRE.JAVA_8)
    public void testJRE() {

    }
    @Test
    public void testNoJRE16() {

    }
}
