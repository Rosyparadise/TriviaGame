
import java.io.*;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList;

/**
 * @author Eleni Navrozidou
 * @author Evangelos Chalkias
 * @version 1.0
 * @since 2020
 *
 * The Score class manages all score changes.
 *
 */

public class Score {
    /**
     * highscore is the highest score player 1 has achieved.
     */
    private int highScore;
    /**
     * f is the name of the file.
     */
    private String f;
    /**
     * Sets the file to be edited.
     * @param f name of the file to be edited.
     */
    public Score(String f){this.f = f;}

    /**
     * This method saves the scores of the two players and the highscore in single player mode in a file named
     * "score.txt".
     *
     * @param scores is an array of scores. If there is one player its length is 1; if two players play the game its 2,
     * saving the score of each player.
     */

    public void setScores(int[] scores){
        File s = new File(f);

        try {
            FileWriter myWriter = new FileWriter(f, true);
            if (s.createNewFile()) {
                this.highScore = 0;
            } else {
                try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
                    String temp = reader.readLine();
                    int h;
                    h = Integer.parseInt(temp);
                    this.highScore = h;
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if(scores.length == 1)
                    setHighScore(scores);
                else{
                    if(scores[0]>scores[1])
                        myWriter.write("Player 1 wins with " + scores[0] + " points. Player 2 loses with " + scores[1] + " points." + "\n");
                    else if(scores[0]<scores[1])
                        myWriter.write("Player 2 wins with " + scores[1] + " points. Player 1 loses with " + scores[0] + " points." + "\n");
                    else
                        myWriter.write("Tie with " + scores[0] + " points.\n");
                }

                myWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method sets the highscore in single player mode, comparing it to the already existing one from previous games.
     *
     * @param scores is an array of scores. If there is one player its length is 1; if two players play the game its 2,
     * saving the score of each player.
     */
    public void setHighScore(int[] scores){
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            this.highScore = Integer.parseInt(reader.readLine());
            if(highScore<scores[0])
                highScore = scores[0];
            ArrayList<String> temp = new ArrayList<>();
            String line;
            temp.add(String.valueOf(highScore));
            while((line = reader.readLine()) != null){
                temp.add(line);
            }
            try(FileWriter fileWriter = new FileWriter(f, false) ){
                fileWriter.write(temp.get(0) + '\n');
                for(int i=1;i< temp.size();i++){
                    String del = temp.get(i) + '\n';
                    fileWriter.append(del);
                }

            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This method saves the results of the two player mode in the file named "score.txt".
     *
     * @return the results of the game of two players.
     */
    public ArrayList<String> printResults(){
        ArrayList<String> temp = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(f))){
            String line;

            temp.add("Personal Highscore: " + reader.readLine());
            temp.add("Match History: ");
            while((line = reader.readLine()) != null){
                temp.add(line);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return temp;
    }

}
