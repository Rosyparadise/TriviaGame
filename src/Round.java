/**
 * @author Evangelos Chalkias
 * @author Eleni Navrozidou
 * @version 1.0
 * @since 2020
 *
 *This class represents each round of the game.
 */
public class Round {
    /**
     * qS is the set of questions in the game.
     */
    private Question[] qS;
    /**
     * typeOfRound is the mode of the round.
     */
    private int typeOfRound;
    /**
     * @param qS is an array of Question objects
     * @param typeOfRound is the mode of the round.
     */
    public Round(Question[] qS,int typeOfRound){
        this.qS=qS;
        this.typeOfRound=typeOfRound;
    }

    /**
     *
     * @return the questionSet.
     */
    public Question[] getqS() {return qS;}

    /**
     *
     * @return the mode of the round.
     */
    public int getTypeOfRound() {return typeOfRound;}



}

