import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Evangelos Chalkias
 * @author Eleni Navrozidou
 * @version 1.0
 * @since 2021
 *
 * Test class for the project class BetQuestion. (JUnit used)
 *
 *
 */
class MainTest {
    /**
     * Constructor initialisation testing
     */
    @Test
    public void mainTest()
    {
        Main main = new Main();
        assertEquals(true,!(main.equals(null)));
    }
    
}