/**
 * @author Evangelos Chalkias
 * @author Eleni Navrozidou
 * @version 2.0
 * @since 2020
 *
 *The BetQuestion class represents the betting mode of the game, where the player can bet some points before each question.
 *This class inherits from the Question class.
 *
 */
public class BetQuestion extends Question{
    /**
     * points that correspond to the question
     */
    private int[] betpoints;
    /**
     @param twoPlayerMode number of players
     *
     *Passes the parameter to the Parent's constructor where the instance is initialised
     */
    public BetQuestion(int twoPlayerMode) {
        super(twoPlayerMode);
    }
    /**
     * Displays the category of the following question and prompts the player to place a certain amount of points.
     * If the player answers correctly, the points are added to their score.
     * If not, the points are subtracted from their score.
     *
     * @return the points the player wins or loses for each question.
     */
    public int[] displayQuestion(int[] answers){
        int[] choice;
        int[] points = new int[getTwoPlayerMode()];
        choice = super.displayQuestion(answers);
        for (int i=0;i<getTwoPlayerMode();i++){
            if (getAnswerArray()[choice[i]-1-(4*i)].equals(getAnswer()))
                points[i] = betpoints[i];
            else
                points[i] = betpoints[i] * -1;
        }
        return points;
    }
    /**
     *
     * @param betpoints the points the player wants to bet.
     */
    public void setBetpoints(int[] betpoints) {this.betpoints=betpoints;}
    
    /**
     *
     * @return returns the integer array betpoints.
     */
    public int[] getBetpoints() {return betpoints;}
}
