import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Evangelos Chalkias
 * @author Eleni Navrozidou
 * @version 1.0
 * @since 2021
 *
 * Test class for the project class ThermoQuestion. (JUnit used)
 *
 *
 */
class ThermoQuestionTest {
    
    /**
     * Test function that uses the displayQuestion function to check how well it responds to different data.
     */
    @Test
    public void displayQuestionTest()
    {
        ThermoQuestion thermo = new ThermoQuestion(2);
        thermo.setCategory("Technology");
        thermo.setAnswer("Monolithic Kernel");
        String[] tempanswers= new String[4];
        tempanswers[0]="Monolithic Kernel";
        tempanswers[1]="Hybrid Kernel";
        tempanswers[2]="Microkernel";
        tempanswers[3]="Simple Kernel";
        thermo.setAnswerArray(tempanswers);
        thermo.setQuestion("Linux is a...");
        int[] choice = new int[2];
        choice[0]=1;
        choice[1]=5;
        long[] timetaken= new long[2];
        timetaken[0]=2652;
        timetaken[1]=2973;
        thermo.setTimeElapsed(timetaken);
        int[] results = thermo.displayQuestion(choice);
        assertEquals(0, results[0]);
        assertEquals(0,results[1]); //1-1
        results = thermo.displayQuestion(choice);
        assertEquals(0, results[0]);
        assertEquals(0,results[1]); //2-2
        results = thermo.displayQuestion(choice);
        assertEquals(0, results[0]);
        assertEquals(0,results[1]); //3-3
        results = thermo.displayQuestion(choice);
        assertEquals(0, results[0]);
        assertEquals(0,results[1]); //4-4
        //both players have answered 4 correctly and it is now up to how fast they answer the last one
        timetaken[1]=2634;
        thermo.setTimeElapsed(timetaken);
        results = thermo.displayQuestion(choice);
        assertEquals(0, results[0]);
        assertEquals(5000,results[1]); //player two should be the winner since both players got it correctly but player 2 answered faster
        
        
        
        
    }
    

}