
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
 * Test class for the project class BetQuestion. (JUnit used)
 *
 *
 */
class BetQuestionTest {
    /**
     * Test function that uses the functionalities of the setters and getters of the class
     */
    @Test
    public void setGetbetPointsTest()
    {
        BetQuestion betq= new BetQuestion(2);
        int[] bet= new int[2];
        bet[0]=250;
        bet[1]=1000;
        betq.setBetpoints(bet);
        int[] results = betq.getBetpoints();
        assertEquals(250,results[0]);
        assertEquals(1000,results[1]);
        
        
    }
    
    /**
     * Test function that uses the displayQuestion function to check how well it responds to different data.
     */
    @Test
    public void displayQuestionTest()
    {
        BetQuestion betq=new BetQuestion(2);
        int[] bet= new int[2];
        int[] answers= new int[2];
        
        betq.setCategory("Science");
        betq.setAnswer("Albert Einstein");
        String[] tempanswers= new String[4];
        tempanswers[0]="Galileo Galilei";
        tempanswers[1]="Albert Einstein";
        tempanswers[2]="Archimedes";
        tempanswers[3]="Isaac Newton";
        betq.setAnswerArray(tempanswers);
        betq.setQuestion("The theory of relativity was introduced in physics by this man.");
        answers[0]=2;
        answers[1]=7;
        bet[0]=750;
        bet[1]=500;
        betq.setBetpoints(bet);
        int[] results =betq.displayQuestion(answers);
        assertEquals(750,results[0]);
        assertEquals(-500,results[1]);
        answers[0]=1;
        answers[1]=6;
        bet[0]=1000;
        bet[1]=250;
        results=betq.displayQuestion(answers);
        assertEquals(-1000,results[0]);
        assertEquals(250,results[1]);
    }
}