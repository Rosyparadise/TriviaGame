/**
 * @author Vagelis Chalkias
 * @author Eleni Navrozidou
 * @version 1.0
 * @since 2020
 *
 * The Player class represents the player playing the game.
 *
 */
public class Player {
    /**
     *points the player's total points.
     */
    private int points;

    /**
     * The constructor sets points to 0.
     */
    public Player()
    {
        points=0;
    }

    /**
     *
     * @return the points of the player.
     */
    public int getPoints(){return points;}

    /**
     *
     * @param amount the points the player won or lost.
     */
    public void addPoints(int amount){points+=amount;}

}
