/**
 * @author Evangelos Chalkias
 * @author Eleni Navrozidou
 * @version 2.0
 * @since 2020
 *
 * The SimpleQuestion class represents the normal mode of the game, where the player has to answer the questions.
 *
 * This class inherits from the Question class.
 *
 */
public class SimpleQuestion extends Question
{

    /**
     * points that correspond to the question
     */

    final private int points = 1000;
    
    /**
     * Constructor that calls the Parent constructor to initialise the instance.
     * @param twoPlayerMode number of players
     */
    public SimpleQuestion(int twoPlayerMode){super(twoPlayerMode);}

    /**
     * Displays the category of the following question.
     * If the player answers correctly, 1000 points are added to their score.
     * If not, no points are gained.
     *
     * @return the points the player wins.
     *
     */
    public int[] displayQuestion(int [] answers){
        int[] choice=super.displayQuestion(answers);
        int[] point = new int[getTwoPlayerMode()];
        for (int i=0;i<getTwoPlayerMode();i++){
            if (getAnswerArray()[choice[i] - 1 - (4 * i)].equals(getAnswer()))
                point[i] = points;
            else
                point[i] = 0;
        }
        return point;
    }
}
