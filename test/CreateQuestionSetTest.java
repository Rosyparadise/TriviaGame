import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Evangelos Chalkias
 * @author Eleni Navrozidou
 * @version 1.0
 * @since 2021
 *
 * Test class for the project class CreateQuestionSet. (JUnit used)
 *
 *
 */


class CreateQuestionSetTest {
    
    /**
     * Test function to check how well the randomise method responds when an array is passed. It is expected to not change arrays at times due to the randomisation factor.
     */
    @Test
    public void randomiseTest()
    {
        CreateQuestionSet questionset = new CreateQuestionSet();
        String array[] = new String[] {"Toyota", "Mercedes", "BMW", "Volkswagen"};
        String randarray[] = array.clone();
        array=questionset.randomise(array);
        assertTrue((!(Arrays.equals(array,randarray))));
        
        String[] array2 = new String[] {"1","2","3"};
        String[] randarray2 = array2.clone();
        array2=questionset.randomise(array2);
        assertTrue((!(Arrays.equals(array2,randarray2))));
        //Won't always be different, since it's randomly shuffled and it might end up staying the same.
        
    }
    
    /**
     * Testing how well the method can initialise the desired children of the parent class Question.
     */
    @Test
    public void pickQuestionTest()
    {
        CreateQuestionSet questionset = new CreateQuestionSet();
        Question[] questions = new Question[8];
        
        questions[0]= questionset.pickQuestion(0,1);
        
        assertEquals(true, (questions[0] instanceof SimpleQuestion));
        questions[1]= questionset.pickQuestion(1,1);;
        assertEquals(true, (questions[1] instanceof ChronoQuestion));
        questions[2]= questionset.pickQuestion(2,1);;
        assertEquals(true, (questions[2] instanceof BetQuestion));
        questions[3]= questionset.pickQuestion(0,2);;
        assertEquals(true, (questions[3] instanceof SimpleQuestion));
        questions[4]= questionset.pickQuestion(1,2);;
        assertEquals(true, (questions[4] instanceof FastQuestion));
        questions[5]= questionset.pickQuestion(2,2);;
        assertEquals(true, (questions[5] instanceof ThermoQuestion));
        questions[6]= questionset.pickQuestion(3,3);;
        assertEquals(true, (questions[6] instanceof ChronoQuestion));
        questions[7]= questionset.pickQuestion(4,4);;
        assertEquals(true, (questions[7] instanceof BetQuestion));
        
    }
    
    /**
     * Test method to test the integrity of the createHash method that returns an array of questions
     */
    @Test
    public void createHashTest()
    {
        CreateQuestionSet questionset = new CreateQuestionSet();
        boolean flag = true;
        Question[] questions1= questionset.createHash(5,0,1);
        Question[] questions2= questionset.createHash(5,1,1);
        Question[] questions3= questionset.createHash(5,6,1);
        Question[] questions4= questionset.createHash(5,0,2);
        Question[] questions5= questionset.createHash(5,1,2);
        Question[] questions6= questionset.createHash(5,2,3);
        Question[] questions7= questionset.createHash(5,3,4);
        Question[] questions8= questionset.createHash(5,123,4);
        for (int i=0;i<5;i++)
        {
            if (!(questions1[i] instanceof SimpleQuestion))
                flag=false;
            else if (!(questions2[i] instanceof ChronoQuestion))
                flag=false;
            else if (!(questions3[i] instanceof BetQuestion))
                flag=false;
            else if (!(questions4[i] instanceof SimpleQuestion))
                flag=false;
            else if (!(questions5[i] instanceof FastQuestion))
                flag=false;
            else if (!(questions6[i] instanceof ThermoQuestion))
                flag=false;
            else if (!(questions7[i] instanceof ChronoQuestion))
                flag=false;
            else if (!(questions8[i] instanceof BetQuestion))
                flag=false;
        }
        assertEquals(true,flag);
        
    }
}