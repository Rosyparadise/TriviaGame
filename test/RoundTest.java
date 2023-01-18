import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Evangelos Chalkias
 * @author Eleni Navrozidou
 * @version 2.0
 * @since 2020
 *
 * The SimpleQuestion class represents the normal mode of the game, where the player has to answer the questions.
 *
 * This class inherits from the Round class.
 *
 */
class RoundTest {
    
    /**
     * Tests if each round contains the desired number of questions and type of round.
     */
    @Test
    public void roundTest()
    {
        CreateQuestionSet set = new CreateQuestionSet();
        Question[] questions= set.createHash(4,2,3);
        Round round = new Round(questions, 2);
        assertNotNull(round.getqS());
        assertEquals(2,round.getTypeOfRound());
        assertTrue(round.getqS()[2] instanceof ThermoQuestion);
        
    }
    
}