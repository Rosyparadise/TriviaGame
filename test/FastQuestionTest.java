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
 * Test class for the project class FastQuestion. (JUnit used)
 *
 *
 */
class FastQuestionTest {
    
    
    /**
     * Test function that uses the displayQuestion function to check how well it responds to different data.
     */
    @Test
    public void displayQuestionTest()
    {
        FastQuestion fast = new FastQuestion(2);
        fast.setCategory("Technology");
        fast.setAnswer("Sony");
        String[] tempanswers= new String[4];
        tempanswers[0]="Panasonic";
        tempanswers[1]="Vin Diesel";
        tempanswers[2]="Sony";
        tempanswers[3]="Philips";
        fast.setAnswerArray(tempanswers);
        fast.setQuestion("What company produced the Walkman?");
        int[] choice = new int[2];
        choice[0]=3;
        choice[1]=8;
        long[] timetaken= new long[2];
        timetaken[0]=4321;
        timetaken[1]=5162;
        fast.setTimeElapsed(timetaken);
        int[] results = fast.displayQuestion(choice);
        assertEquals(1000, results[0]);
        assertEquals(0,results[1]);
        timetaken[1]=2634;
        choice[1]=7;
        fast.setTimeElapsed(timetaken);
        results = fast.displayQuestion(choice);
        assertEquals(500, results[0]);
        assertEquals(1000,results[1]);
    }
}