import java.lang.Math;
/**
 * @author Evangelos Chalkias
 * @author Eleni Navrozidou
 * @version 2.0
 * @since 2020
 *
 *The ChronoQuestion class represents the timer mode of the game, where the player has to answer all the questions in time.
 *This class inherits from the Question class.
 *
 */
public class ChronoQuestion extends Question{
    /**
     *
     * @param twoPlayerMode the number of players.
     */
    public ChronoQuestion(int twoPlayerMode){
        super(twoPlayerMode);
    }
    /**
     * This method gets the time the player took to answer each question and adds the points won.
     * @param answers the array of the numbers of the answers each player chose.
     * @return the points.
     */
    public int[] displayQuestion(int[] answers){
        int[] choice=super.displayQuestion(answers);
        int[] points = new int[getTwoPlayerMode()];
        for (int i=0;i<getTwoPlayerMode();i++){
            if (getAnswerArray()[choice[i] - 1 - (4 * i)].equals(getAnswer()))
                points[i]=(int)Math.round((5000-getTimeElapsed()[i])*0.2);
            else
                points[i]=0;
            if (5000-getTimeElapsed()[i]<0)
                points[i]=0;
        }
        return points;
    }
}
