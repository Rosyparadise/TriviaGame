import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Evangelos Chalkias
 * @author Eleni Navrozidou
 * @version 1.0
 * @since 2021
 *
 * Test class for the project class Database. (JUnit used)
 *
 *
 */
class DatabaseTest {
    /**
     * Tests if the initialisation in createArrays works as expected.
     */
    @Test
    public void createArraysTest()
    {
        Database data = new Database();
        assertFalse(data.getQuestionTypes()[0].isEmpty());
        assertFalse(data.getQuestionTypes()[1].isEmpty());
        assertFalse(data.getQuestionTypes()[2].isEmpty());
        assertFalse(data.getQuestionTypes()[3].isEmpty());
    }
    
    /**
     * Tests the functionalities of the setters and getters of the class
     */
    @Test
    public void gettersTest()
    {
        Database data = new Database();
        assertTrue(data.getQuestionTypes()!=null);
        assertEquals(4,data.getQuestionTypes().length);
        assertTrue(data.getLength(0)!=0);
        assertTrue(data.getLength(1)!=0);
        assertTrue(data.getLength(2)!=0);
        assertTrue(data.getLength(3)!=0);
        
        
    }
    
}