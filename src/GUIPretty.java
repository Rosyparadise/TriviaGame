import javax.swing.*;
import java.awt.*;
/**
 * @author Eleni Navrozidou
 * @author Vagelis Chalkias
 * @version 2.0
 * @since 2020
 *
 * This class makes the gui of the the game prettier.
 */
public class GUIPretty{
    /**
     * game is the current game.
     */
    private final Game game;
    /**
     * frame is the current frame.
     */
    private final Frame frame;
    /**
     * pointsP1 is the label displaying the points of p1.
     */
    private JLabel pointsP1;
    /**
     * pointsP2 is the label displaying the points of p2.
     */
    private JLabel pointsP2;
    /**
     * pretty is the label displaying the number of the question.
     */
    private final JLabel pretty;
    /**
     * r is the label displaying the number of the round.
     */
    private final JLabel r;
    /**
     * pl1 is the label displaying player 1.
     */
    private JLabel pl1;
    /**
     * pl2 is the label displaying player 2.
     */
    private JLabel pl2;
    /**
     * cat is the label displaying the category of the question.
     */
    private final JLabel cat;

    /**
     *
     * @param game is the current game.
     * @param frame is the current frame.
     */
    public GUIPretty(Game game, Frame frame){
        this.game=game;
        this.frame=frame;
        pointsP1 = new JLabel();
        pointsP1.setForeground(Color.white);
        pointsP1.setBounds(20, 400, 300, 30);
        pointsP1.setFont(new Font("Arial",Font.BOLD,30));
        pointsP1.setVisible(false);
        this.frame.add(pointsP1);

        if (game.getNumberPlayers()>1){
            pointsP2 = new JLabel();
            pointsP2.setForeground(Color.white);
            pointsP2.setBounds(990, 400, 300, 30);
            pointsP2.setFont(new Font("Arial",Font.BOLD,30));
            pointsP2.setVisible(false);
            this.frame.add(pointsP2);
        }

        pl1 = new JLabel("Player 1");
        pl1.setForeground(Color.cyan);
        pl1.setBounds(20, 200, 300, 30);
        pl1.setFont(new Font("Arial",Font.BOLD,30));
        pl1.setVisible(false);
        this.frame.add(pl1);

        if (game.getNumberPlayers()>1){
            pl2 = new JLabel("Player 2");
            pl2.setForeground(Color.red);
            pl2.setBounds(1000, 200, 300, 30);
            pl2.setFont(new Font("Arial", Font.BOLD, 30));
            pl2.setVisible(false);
            frame.add(pl2);
        }

        pretty = new JLabel("");
        pretty.setForeground(Color.WHITE);
        pretty.setBounds(560, 100, 300, 30);
        pretty.setFont(new Font("Arial", Font.ITALIC, 17));
        pretty.setVisible(false);
        this.frame.add(pretty);

        cat = new JLabel("");
        cat.setForeground(Color.orange);
        cat.setBounds(100, 120, 300, 30);
        cat.setFont(new Font("Arial", Font.BOLD, 15));
        this.frame.add(cat);

        r = new JLabel("");
        r.setForeground(Color.WHITE);
        r.setBounds(570, 60, 300, 30);
        r.setFont(new Font("Arial", Font.BOLD, 15));
        this.frame.add(r);
    }

    /**
     * This method makes the gui prettier.
     * @param i is the number of the question the player is currently playing.
     * @param j is the number of the round the player is currently playing.
     */
    public void makeFab(int i, int j){
        cat.setText(game.getGameSetup()[i].getqS()[j].getCategory());
        pl1.setVisible(true);

        pretty.setText("Question " + (j+1));
        r.setText("Round " + (i+1));
        r.setVisible(true);
        pointsP1.setText("Points: " + game.getPlayers()[0].getPoints());
        pointsP1.setVisible(true);
        pretty.setVisible(true);

        if (game.getNumberPlayers()>1){
            pointsP2.setText("Points: " + game.getPlayers()[1].getPoints());
            pointsP2.setVisible(true);
            pl2.setVisible(true);
        }
    }

    /**
     * This method is the ending screen of the game.
     * @param scores the final scores of each player.
     */
    public void endingScreen(JButton scores){

        scores.setVisible(true);
        frame.add(scores);

        JLabel finalScore = new JLabel("Game Over!");
        finalScore.setForeground(Color.ORANGE);
        finalScore.setBounds(500, 100, 200, 30);
        finalScore.setFont(new Font("Arial",Font.BOLD,30));
        finalScore.setVisible(true);
        frame.add(finalScore);

        if(game.getNumberPlayers() == 1){
            JLabel score = new JLabel("Your score is " + game.getPlayers()[0].getPoints());
            score.setForeground(Color.WHITE);
            score.setBounds(500, 200, 500, 30);
            score.setFont(new Font("Arial",Font.BOLD,30));
            score.setVisible(true);
            frame.add(score);
        }else{
            JLabel score1 = new JLabel("Player 1 score is " + game.getPlayers()[0].getPoints());
            score1.setForeground(Color.WHITE);
            score1.setBounds(440, 200, 500, 30);
            score1.setFont(new Font("Arial",Font.BOLD,30));
            score1.setVisible(true);
            frame.add(score1);

            JLabel score2 = new JLabel("Player 2 score is " + game.getPlayers()[1].getPoints());
            score2.setForeground(Color.WHITE);
            score2.setBounds(440, 250, 500, 30);
            score2.setFont(new Font("Arial",Font.BOLD,30));
            score2.setVisible(true);
            frame.add(score2);

            if(game.getPlayers()[0].getPoints()>game.getPlayers()[1].getPoints()){
                JLabel results = new JLabel("Player 1 won!");
                results.setForeground(Color.cyan);
                results.setBounds(500, 400, 500, 30);
                results.setFont(new Font("Arial",Font.BOLD,30));
                results.setVisible(true);
                frame.add(results);
            }else if(game.getPlayers()[0].getPoints()<game.getPlayers()[1].getPoints()){
                JLabel results = new JLabel("Player 2 won!");
                results.setForeground(Color.red);
                results.setBounds(500, 450, 500, 30);
                results.setFont(new Font("Arial",Font.BOLD,30));
                results.setVisible(true);
                frame.add(results);
            }else{
                JLabel results = new JLabel("Tie!");
                results.setForeground(Color.red);
                results.setBounds(500, 450, 500, 30);
                results.setFont(new Font("Arial",Font.BOLD,30));
                results.setVisible(true);
                frame.add(results);
            }
        }
    }

}
