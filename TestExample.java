import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestExample {
    @Test
    public void test() {
        Code code =  new Code();
        assertEquals("Hello guys!",code.Sayhello());
    }
}
