import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.Math;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Evangelos Chalkias
 * @author Eleni Navrozidou
 * @version 1.0
 * @since 2021
 *
 * Test class for the project class ChronoQuestion, child of Question. (JUnit used)
 *
 *
 */
class ChronoQuestionTest {
    
    /**
     * Test function that uses the displayQuestion function within ChronoQuestion to check how well it responds to different data.
     */
    @Test
    public void displayQuestionTest()
    {
        ChronoQuestion chrono = new ChronoQuestion(2);
        chrono.setCategory("Films");
        chrono.setAnswer("Vin Diesel");
        String[] tempanswers= new String[4];
        tempanswers[0]="John Travolta";
        tempanswers[1]="Vin Diesel";
        tempanswers[2]="Keanu Reeves";
        tempanswers[3]="Dwayne Johnson";
        chrono.setAnswerArray(tempanswers);
        chrono.setQuestion("Who plays as Dominic Toretto in The Fast and the Furious?");
        int[] choice = new int[2];
        choice[0]=2;
        choice[1]=5;
        long[] timetaken= new long[2];
        timetaken[0]=4311;
        timetaken[1]=3745;
        chrono.setTimeElapsed(timetaken);
        int[] results = chrono.displayQuestion(choice);
        assertEquals(Math.round((5000-4311)*0.2), results[0]);
        assertEquals(0,results[1]);
        choice[0]=1;
        choice[1]=6;
        results = chrono.displayQuestion(choice);
        assertEquals(0, results[0]);
        assertEquals(Math.round((5000-3745)*0.2),results[1]);
        timetaken[1]=5001;
        chrono.setTimeElapsed(timetaken);
        results = chrono.displayQuestion(choice);
        assertEquals(0,results[1]);
    }
}