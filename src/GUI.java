import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * @author Eleni Navrozidou
 * @author Vagelis Chalkias
 * @version 2.0
 * @since 2020
 *
 * This class is the gui of the starting screen.
 */
public class GUI extends JFrame {
    /**
     * frame is the window the game is played.
     */

    private JFrame frame;
    /**
     * title is the title of the game being displayed in the starting screen.
     */
    private JLabel title;
    /**
     * credits is a label of the creators.
     */

    private JLabel credits;
    /**
    * newGame is the button to start a new game.
     */

    private JButton newGame;
    /**
     * scores is the button to show match history.
     */
    private JButton scores;
    /**
     * color is the color of a default button.
     */
    private Color color;
    /**
     * modes is array of the modes the players want to play in each game.
     */
    private int[] modes;
    /**
     * players is the number of players.
     */
    private int players;
    /**
     * round is the number of rounds.
     */
    private int round;
    /**
     * q is the number of questions.
     */
    private int  q;
    /**
     * game is the current game.
     */
    private Game game;
    /**
    * guigame is the gui for the game.
     */
    private GUIGame guigame;

    /**
     * In the constructor we initialize all of the components for the frame.
     **/
    public GUI(){

        frame = new JFrame("BUZZ!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(1200,650);
        Container c=frame.getContentPane();
        c.setBackground(Color.DARK_GRAY);


        title = new JLabel("BUZZ! QUIZ WORLD");
        title.setBounds(450, 100, 300, 30);
        title.setFont(new Font("Arial",Font.BOLD,30));
        title.setForeground(Color.WHITE);
        frame.add(title);

        credits = new JLabel("Made by Eleni Navrozidou and Evangelos Chalkias.");
        credits.setBounds(450, 550, 400, 30);
        credits.setFont(new Font("Arial", Font.ITALIC, 15));
        credits.setForeground(Color.GRAY);
        frame.add(credits);

        newGame = new JButton("New Game");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGame();
                guigame= new GUIGame(game.getGui(),game,frame);
            }
        });
        color = newGame.getBackground();
        newGame.setBounds(520, 200, 150, 80);
        frame.add(newGame);

        scores = new JButton("Match History");
        scores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showScore();
            }
        });
        scores.setBounds(520, 300, 150, 80);
        frame.add(scores);
        frame.setVisible(true);
    }

    /**
     * This is the method being called when the button "New Game" is clicked.
     * It sets all of the important elements needed to start the game.
     */
    private void newGame(){
        JTextField numberP = new JTextField("");
        JTextField numberR = new JTextField("");
        JTextField numberQ = new JTextField("");
        Object[] obj = {"How many players? (1-2) \n\n", numberP};
        Object[] obj1 = {"Almost done! Pick number of rounds (1-7): \n\n", numberR};
        Object[] obj2 = {"And lastly, pick number of questions (5-13): \n\n", numberQ};
        Object stringArray[] = {"OK", "Cancel"};
        players = 0;
        q = 0;
        round = 0;
         while(players<1 || players>2)
             if (JOptionPane.showOptionDialog(frame, obj, "Number of Players", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, stringArray, obj) == JOptionPane.OK_OPTION)
                 players = Integer.parseInt(numberP.getText());
         while (round < 1 || round > 7)
             if (JOptionPane.showOptionDialog(frame, obj1, "Number of Rounds", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, stringArray, obj1) == JOptionPane.OK_OPTION)
                 round = Integer.parseInt(numberR.getText());
         while(q<5 || q>13)
             if (JOptionPane.showOptionDialog(frame, obj2, "Number of Questions", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, stringArray, obj2) == JOptionPane.OK_OPTION)
                 q = Integer.parseInt(numberQ.getText());
         newGame.setVisible(false);
         scores.setVisible(false);
         title.setVisible(false);
         credits.setVisible(false);

         modes = readType(Integer.parseInt(numberP.getText()), Integer.parseInt(numberR.getText()));
         game = new Game(numberP.getText(), numberR.getText(), numberQ.getText(), modes);
         game.setGui(this);
    }

    /**
     * This method is to read the mode the player wants to play in each round.
     * @param p number of players.
     * @param rounds number of rounds.
     * @return the array of the modes.
     */
    public int[] readType(int p, int rounds){
        JTextField choose = new JTextField("");
        Object[] obj1 = {"Type the number of the mode you want to play:\n1.Normal\n2.Chronometer\n3.Bet\n\n", choose};
        Object[] obj2 = {"Type the number of the mode you want to play:\n1.Normal\n2.Speed\n3.Thermometer\n4.Chronometer\n5.Bet\n\n", choose};
        Object sA[] = {"OK"};
        int[] temp = new int[rounds];

        if(p == 1){
            for(int i=0; i<rounds;i++){
                temp[i]=0;
                while(temp[i]<1 || temp[i]>3)
                    if (JOptionPane.showOptionDialog(frame, obj1, ("Game Mode for Round " + (i+1)), JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, sA, obj1) == JOptionPane.OK_OPTION){
                        temp[i] = Integer.parseInt(choose.getText());
                        choose.setText("");
                    }
            }
        }
        else if(p==2){
            for(int i=0; i<rounds;i++){
                temp[i] = 0;
                while(temp[i]<1 || temp[i]>5) {
                    if (JOptionPane.showOptionDialog(frame, obj2, ("Game Mode for Round " + (i + 1)), JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, sA, obj2) == JOptionPane.OK_OPTION) {
                        if (choose.getText().equals("1") || choose.getText().equals("2") || choose.getText().equals("3") || choose.getText().equals("4") || choose.getText().equals("5")) {
                            temp[i] = Integer.parseInt(choose.getText());
                            choose.setText("");
                        }
                    }
                }
            }
        }
        return temp;
    }

    /**
     * This method is called when the "Match History" button is clicked.
     * It then opens another window, containing the scores of the two player mode and the highscore in single player.
     */
    public void showScore(){
        Score score = new Score("score.txt");
        ArrayList<String> temp = score.printResults();

        JList<String> displayList = new JList<>(temp.toArray(new String[0]));
        JScrollPane scrollPane = new JScrollPane(displayList);
        getContentPane().add(scrollPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }

    /**
     *
     * @return the color of the newGame button.
     */
    public Color getColor() {return color;}

    /**
     *
     * @return the scores button.
     */
    public JButton getScoreButton() {return scores;}

}
