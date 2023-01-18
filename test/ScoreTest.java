import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Eleni Navrozidou
 * @author Evangelos Chalkias
 * @version 1.0
 * @since 2021
 *
 * Test class for the project class Score. (JUnit used)
 *
 *
 */
class ScoreTest {
    /**
     * Tests how well the score setting method works.
     */
    @Test
    public void setScoreTest(){
        Score s = new Score("testFiles.txt");
        int[] score = {100};
        int[] scores = {100, 200};

        int h = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("testFiles.txt"))) {
            h = Integer.parseInt(reader.readLine());
        }catch (IOException e ){
            e.printStackTrace();
        }

        if(score[0]>=h)
            assertEquals(score[0], h);

        s.setScores(score);
        String lastLine = "";
        s.setScores(scores);
        try {
            String CurrentLine;

            BufferedReader br = new BufferedReader(new FileReader("testFiles.txt"));
            while ((CurrentLine = br.readLine()) != null){
                lastLine = CurrentLine;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(scores[0]>scores[1])
            assertEquals("Player 1 wins with " + scores[0] + " points. Player 2 loses with " + scores[1] + " points.", lastLine);
        else if(scores[0]<scores[1])
            assertEquals("Player 2 wins with " + scores[1] + " points. Player 1 loses with " + scores[0] + " points.", lastLine);
        else
            assertEquals("Tie with " + scores[0] + " points.", lastLine);

    }

    /**
     * Tests how well the Highscore is set.
     */
    @Test
    public void setHighscoreTest(){
        int[] score = {100};
        Score s =  new Score("testFiles.txt");

        int h = 0;
        int actual = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("testFiles.txt"))) {
            h = Integer.parseInt(reader.readLine());
        }catch (IOException e ){
            e.printStackTrace();
        }

        s.setHighScore(score);
        try (BufferedReader reader = new BufferedReader(new FileReader("testFiles.txt"))) {
            actual = Integer.parseInt(reader.readLine());
        }catch (IOException e ){
            e.printStackTrace();
        }

        if(score[0]>=h)
            assertEquals(score[0], actual);

    }

    /**
     * Tests how well the printing data method works.
     */
    @Test
    public void printResultsTest(){
        Score s = new Score("testFiles.txt");
        ArrayList<String> temp =new ArrayList<>();
        ArrayList<String> temp1 = new ArrayList<>();

        s.setScores(new int[]{100, 200});
        temp = s.printResults();
        s.setScores(new int[]{300, 100});
        temp1 = s.printResults();
        temp.add("Player 1 wins with " + 300 + " points. Player 2 loses with " + 100 + " points.");
        assertEquals(temp, temp1);

    }


}