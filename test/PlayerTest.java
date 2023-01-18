import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Evangelos Chalkias
 * @author Eleni Navrozidou
 * @version 1.0
 * @since 2021
 *
 * Test class for the project class PlayerTest. (JUnit used)
 *
 *
 */
class PlayerTest {
    /**
     * Method to test how well point addition works with different data.
     */
    @Test
    public void addPointsTest()
    {
        Player player= new Player();
        player.addPoints(300);
        player.addPoints(800);
        assertEquals(1100,player.getPoints());
        player.addPoints(-700);
        assertEquals(400,player.getPoints());
        player.addPoints(-4000);
        assertEquals(-3600,player.getPoints());
        player.addPoints(3600);
        assertEquals(0,player.getPoints());
        player.addPoints(0);
        assertEquals(0,player.getPoints());
    }
    
}