import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class StudentTest {

    @Test
    public void allTests() {
        testWire0();
        testWire1();
    }

    @Test
    public void testWire0() {
        assertTimeout(Duration.ofMillis(1000), () -> {
            Utilities.test("./test/inputs/wire0.in");
        });
    }

    // your tests go here
    @Test
    public void testWire1() {
        long start = System.currentTimeMillis();
        assertTimeout(Duration.ofMillis(1000), () -> {
            Utilities.test("./test/inputs/wire1.in");
        });
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
    }
}
