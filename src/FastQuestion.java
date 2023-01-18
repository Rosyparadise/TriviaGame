/**
 * @author Evangelos Chalkias
 * @author Eleni Navrozidou
 * @version 1.0
 * @since 2020
 *
 *The FastQuestion class represents the time attack mode of the game, in which the fastest correct answer wins the most points.
 *This class inherits from the Question class.
 *
 */
public class FastQuestion extends Question{
    /**
     *
     * @param twoPlayerMode number of players.
     */
    public FastQuestion(int twoPlayerMode){
        super(twoPlayerMode);
    }

    /**
     * @param answers the numbers of the answers each player chose.
     * @return the points won.
     */
    public int[] displayQuestion(int[] answers){
        int[] choice=super.displayQuestion(answers);
        int[] points = new int[getTwoPlayerMode()];
        long mintime = getTimeElapsed()[0];

        for (int i=0;i<getTwoPlayerMode();i++){
            if (getTimeElapsed()[i]<mintime){
                mintime=getTimeElapsed()[i];
            }
        }
        for (int i=0;i<getTwoPlayerMode();i++){
            int temp;
            if (getAnswerArray()[choice[i] - 1 - (4 * i)].equals(getAnswer())){
                temp = i == 0 ? 1 : 0;

                if (getTimeElapsed()[i]==mintime || choice[temp] ==0 || !(getAnswerArray()[choice[temp] - 1 - (4 * temp)].equals(getAnswer())))
                    points[i]=1000;
                else
                    points[i]=500;
            }
            else
                points[i]=0;
        }
        return points;
    }
}
