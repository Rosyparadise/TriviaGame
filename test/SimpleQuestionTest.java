import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Evangelos Chalkias
 * @author Eleni Navrozidou
 * @version 1.0
 * @since 2021
 *
 * Test class for the project class SimpleQuestion. (JUnit used)
 *
 *
 */
class SimpleQuestionTest {
    
    
    
    
    /**
     * Test function that uses the displayQuestion function to check how well it responds to different data.
     */
    @Test
    public void displayQuestionTest()
    {
        SimpleQuestion simp= new SimpleQuestion(2);
        
        simp.setCategory("Food");
        simp.setAnswer("Peanuts");
        String[] tempanswers= new String[4];
        tempanswers[0]="Walnuts";
        tempanswers[1]="Pine Nuts";
        tempanswers[2]="Almonds";
        tempanswers[3]="Peanuts";
        simp.setAnswerArray(tempanswers);
        simp.setQuestion("Which nut is used to make dynamite?");
        int[] choice = new int[2];
        choice[0]=4;
        choice[1]=6;
        int[] results = simp.displayQuestion(choice);
        assertEquals(1000, results[0]);
        assertEquals(0,results[1]);
        choice[0]=2;
        choice[1]=8;
        results = simp.displayQuestion(choice);
        assertEquals(0, results[0]);
        assertEquals(1000,results[1]);
    }
}