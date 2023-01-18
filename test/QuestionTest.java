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
 * Test class for the project class Question. (JUnit used)
 *
 *
 */
class QuestionTest {
    
    
    /**
     * Method to test the functionality of the setters and getters in the abstract class Question.
     */
    @Test
    public void settersgettersTest()
    {
        Question question = new SimpleQuestion(2);
        assertEquals(2,question.getTwoPlayerMode());
        String tempquestion = "To be or not to be?";
        question.setQuestion(tempquestion);
        assertEquals("To be or not to be?",question.getQuestion());
        String tempanswer = "it depends.";
        question.setAnswer(tempanswer);
        assertEquals("it depends.",question.getAnswer());
        String[] tempanswers = new String[4];
        tempanswers[0]="idk";
        tempanswers[1]="yeah i guess";
        tempanswers[2]="not really";
        tempanswers[3]="it depends.";
        question.setAnswerArray(tempanswers);
        assertEquals("idk",question.getAnswerArray()[0]);
        assertEquals("yeah i guess",question.getAnswerArray()[1]);
        assertEquals("not really",question.getAnswerArray()[2]);
        assertEquals("it depends.",question.getAnswerArray()[3]);
        question.setCategory("Science");
        assertEquals("Science",question.getCategory());
        long[] times = new long[2];
        times[0]=5000;
        times[1]=4520;
        question.setTimeElapsed(times);
        assertEquals(times[0],question.getTimeElapsed()[0]);
        assertEquals(times[1],question.getTimeElapsed()[1]);
        question.setImage("imagetest01.png");
        assertEquals("imagetest01.png",question.getImage());
        
        
    }
}