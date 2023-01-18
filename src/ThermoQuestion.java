/**
 * @author Evangelos Chalkias
 * @author Eleni Navrozidou
 * @version 2.0
 * @since 2020
 *
 * This class represents the Thermometer mode of the game, in which each player has to answer 5 questions correctly
 * and whoever does it first wins 5000 points.
 *
 * This class inherits from the Question class.
 *
 */
public class ThermoQuestion extends Question{
    
    /**
     * How many answers the players have gotten correctly. Resets to 0 when a player reaches 5.
     */
    private static int[] correctAnswers = new int[2];

    /**
     *
     * @param twoPlayerMode the number of players.
     */
    public ThermoQuestion(int twoPlayerMode)
    {
        super(twoPlayerMode);
    }

    /**
     * This method calculates the points the player earns.
     * @param answers the answers of the player.
     * @return the points.
     */
    public int[] displayQuestion(int[] answers){
        int[] choice=super.displayQuestion(answers);
        int[] points = new int[getTwoPlayerMode()];
        long mintime = getTimeElapsed()[0];

        for (int i=0;i<getTwoPlayerMode();i++){
            if (getTimeElapsed()[i]<mintime && getAnswerArray()[choice[i] - 1 - (4 * i)].equals(getAnswer()))
                mintime=getTimeElapsed()[i];
        }
        int temp;

        for (int i=0;i<getTwoPlayerMode();i++){
            if (getAnswerArray()[choice[i] - 1 - (4 * i)].equals(getAnswer())){
                temp = i == 0 ? 1 : 0;
                correctAnswers[i]++;
                if ((correctAnswers[i]==5 && (getTimeElapsed()[i]==mintime||i==1)) || (correctAnswers[i]==5 && !(correctAnswers[temp]==4 && getAnswerArray()[choice[temp] - 1 - (4 * temp)].equals(getAnswer())))) {
                    correctAnswers[0]=0;
                    correctAnswers[1]=0;
                    points[i]=5000;
                    points[temp]=0;
                    return points;
                }else
                    points[i]=0;
            }else
                points[i]=0;
        }
        return points;
    }
}
