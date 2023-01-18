import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Evangelos Chalkias
 * @author Eleni Navrozidou
 * @version 1.0
 * @since 2021
 *
 * Test class for the project class Game. (JUnit used)
 *
 *
 */
class GameTest {
    
    /**
     *Tests how well the initialisation in the method game works.
     */
    @Test
    public void gameTest(){
        int[] t = new int[]{1,2,3,4,5,2};
        Game game = new Game("2","6","10",t);
        assertEquals(2,game.getNumberPlayers());
        assertEquals(2,game.getPlayers().length);
        assertEquals(0,game.getPlayers()[0].getPoints());
        assertEquals(0,game.getPlayers()[0].getPoints());
        game.getPlayers()[1].addPoints(100);
        assertEquals(100,game.getPlayers()[1].getPoints());
        assertEquals(6,game.getGameSetup().length);
        assertEquals(0,game.getGameSetup()[0].getTypeOfRound());
        assertEquals(1,game.getGameSetup()[5].getTypeOfRound());
        assertEquals(6,game.getRounds());
        assertEquals(10,game.getQuestions());

    }

    /**
     * Tests how well the data is stored.
     */
    @Test
    public void logDataTest() {

        int[] t1 = new int[]{1, 2, 3, 2, 1, 2};
        Game game = new Game("1", "6", "10", t1);
        int h = 0;
        game.getPlayers()[0].addPoints(100);
        int p = game.getPlayers()[0].getPoints();
        try (BufferedReader reader = new BufferedReader(new FileReader("testFiles.txt"))) {
            String temp = reader.readLine();
            h = Integer.parseInt(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        game.logData("testFiles.txt");

        if(p<h)
            assertEquals(p, h);

        Game game2 = new Game("2", "6", "10", t1);
        game2.getPlayers()[0].addPoints(100);
        game2.getPlayers()[1].addPoints(1000);
        int pOne = game2.getPlayers()[0].getPoints();
        int pTwo = game2.getPlayers()[1].getPoints();
        String lastLine = "";

        game2.logData("testFiles.txt");
        try {
            String CurrentLine;

            BufferedReader br = new BufferedReader(new FileReader("testFiles.txt"));
            while ((CurrentLine = br.readLine()) != null){
                lastLine = CurrentLine;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(pOne>pTwo)
            assertEquals("Player 1 wins with " + pOne + " points. Player 2 loses with " + pTwo + " points.", lastLine);
        else if(pOne<pTwo)
            assertEquals("Player 2 wins with " + pTwo + " points. Player 1 loses with " + pOne + " points.", lastLine);
        else
            assertEquals("Tie with " + pOne + " points.", lastLine);


    }


}