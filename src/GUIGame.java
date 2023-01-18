import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Eleni Navrozidou
 * @author Vagelis Chalkias
 * @version 2.0
 * @since 2020
 *
 * This class is the gui of the game when it starts.
 */
public class GUIGame {
    /**
     * gui is the gui created.
     */
    private final GUI gui;
    /**
     * game is the current game.
     */
    private final Game game;
    /**
     * frame is the current frame.
     */
    private final JFrame frame;
    /**
     * a1 is the button of the first possible answer p1 uses to answer each question.
     */

    private final JButton a1;
    /**
     * a2 is the button of the second possible answer p1 uses to answer each question.
     */
    private final JButton a2;
    /**
     * a3 is the button of the third possible answer p1 uses to answer each question.
     */
    private final JButton a3;
    /**
     * a2 is the button of the fourth possible answer p1 uses to answer each question.
     */
    private final JButton a4;
    /**
     * a5 is the button of the first possible answer p2 uses to answer each question.
     */
    private JButton a5;
    /**
     * a6 is the button of the second possible answer p2 uses to answer each question.
     */
    private JButton a6;
    /**
     * a7 is the button of the third possible answer p2 uses to answer each question.
     */
    private JButton a7;
    /**
     * a8 is the button of the fourth possible answer p2 uses to answer each question.
     */
    private JButton a8;
    /**
     * question is the label of the question.
     */
    private final JTextArea question;
    /**
     * answers is the array of the answer each player gives in each round.
     */
    private final int[] answers;
    /**
     * i is the number of the current round.
     */
    private int i;
    /**
     * j is the number of the current question.
     */
    private int j;
    /**
     * timeElapsedGUI time taken to answer the question.
     */
    private final long[] timeElapsedGUI;
    /**
     * start is the beggining of the timer.
     */
    private long start;
    /**
     * end is the end of the timer.
     */
    private long end;
    /**
     * icon is the image object.
     */
    private ImageIcon icon;
    /**
     * label is the label displaying the image.
     */
    private JLabel label;
    /**
     * guipretty is the object to make prettier the current gui.
     */
    private final GUIPretty guipretty;
    /**
     * time is the object that displays the timer in another frame.
     */
    private TimerWindow time;

    /**
     *
     * @param gui is the gui .
     * @param game is the current game.
     * @param frame is the frame used from the starting screen.
     */
    public GUIGame(GUI gui, Game game, JFrame frame) {
        i = 0;
        j = 0;
        answers = new int[game.getNumberPlayers()];
        timeElapsedGUI = new long[answers.length];
        start = System.currentTimeMillis();
        for (int i = 0; i < game.getNumberPlayers(); i++) {
            answers[i] = 0;
        }
        question = new JTextArea(3, 10);
        question.setWrapStyleWord(true);
        question.setLineWrap(true);
        question.setFont(new Font("Arial", Font.BOLD, 50));
        question.setForeground(Color.WHITE);
        question.setBounds(100, 150, 1000, 100);
        question.setFont(new Font("Arial", Font.BOLD, 15));
        question.setRows(2);
        question.setOpaque(false);
        question.setEditable(false);
        question.setText(game.getGameSetup()[0].getqS()[0].getQuestion());

        a1 = new JButton();
        a1.setMnemonic('1');
        a1.setText(game.getGameSetup()[0].getqS()[0].getAnswerArray()[0]);
        a1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == a1) {
                    answers[0] = 1;
                    end = System.currentTimeMillis();
                    a1.setBackground(Color.CYAN);
                    disableBut("1", false);
                    timeElapsedGUI[0]= end - start;
                    if((answers.length>1 && answers[1]!=0)||(answers.length==1))
                        setupGame();
                    else
                        disableBut("1",false);
                }
            }
        });

        a2 = new JButton();
        a2.setMnemonic('2');a2.setText(game.getGameSetup()[0].getqS()[0].getAnswerArray()[1]);
        a2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == a2) {
                    answers[0] = 2;
                    end = System.currentTimeMillis();
                    a2.setBackground(Color.CYAN);
                    disableBut("1", false);
                    timeElapsedGUI[0]= end - start;
                    if((answers.length>1 && answers[1]!=0)||(answers.length==1))
                        setupGame();

                    else
                        disableBut("1",false);
                }
            }
        });

        a3 = new JButton();
        a3.setMnemonic('3');
        a3.setText(game.getGameSetup()[0].getqS()[0].getAnswerArray()[2]);
        a3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == a3) {
                    answers[0] = 3;
                    end = System.currentTimeMillis();
                    a3.setBackground(Color.CYAN);
                    disableBut("1", false);
                    timeElapsedGUI[0]= end - start;
                    if((answers.length>1 && answers[1]!=0)||(answers.length==1))
                        setupGame();
                    else
                        disableBut("1",false);
                }
            }
        });

        a4 = new JButton();
        a4.setMnemonic('4');
        a4.setText(game.getGameSetup()[0].getqS()[0].getAnswerArray()[3]);
        a4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == a4) {
                    answers[0] = 4;
                    end = System.currentTimeMillis();
                    a4.setBackground(Color.CYAN);
                    disableBut("1", false);
                    timeElapsedGUI[0]= end - start;
                    if((answers.length>1 && answers[1]!=0)||(answers.length==1))
                        setupGame();
                    else
                        disableBut("1",false);
                }
            }
        });

        if (answers.length==2)
        {
            a5 = new JButton();
            a5.setMnemonic('5');
            a5.setText(game.getGameSetup()[0].getqS()[0].getAnswerArray()[0]);
            a5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == a5) {
                        answers[1] = 5;
                        end = System.currentTimeMillis();
                        a5.setBackground(Color.PINK);
                        disableBut("2", false);
                        timeElapsedGUI[1]= end - start;
                        if(answers[0]!=0)
                            setupGame();
                        else
                            disableBut("2",false);
                    }
                }
            });

            a6 = new JButton();
            a6.setMnemonic('6');
            a6.setText(game.getGameSetup()[0].getqS()[0].getAnswerArray()[1]);
            a6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == a6) {
                        answers[1] = 6;
                        end = System.currentTimeMillis();
                        a6.setBackground(Color.PINK);
                        disableBut("2", false);
                        timeElapsedGUI[1]= end - start;
                        if(answers[0]!=0)
                            setupGame();
                        else
                            disableBut("2",false);
                    }
                }
            });

            a7 = new JButton();
            a7.setMnemonic('7');
            a7.setText(game.getGameSetup()[0].getqS()[0].getAnswerArray()[2]);
            a7.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == a7) {
                        answers[1] = 7;
                        end = System.currentTimeMillis();
                        a7.setBackground(Color.PINK);
                        disableBut("2", false);
                        timeElapsedGUI[1]= end - start;
                        if(answers[0]!=0)
                            setupGame();
                        else
                            disableBut("2",false);
                    }
                }
            });

            a8 = new JButton();
            a8.setMnemonic('8');
            a8.setText(game.getGameSetup()[0].getqS()[0].getAnswerArray()[3]);
            a8.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == a8) {
                        answers[1] = 8;
                        end = System.currentTimeMillis();
                        a8.setBackground(Color.PINK);
                        disableBut("2", false);
                        timeElapsedGUI[1]= end - start;
                        if(answers[0]!=0)
                            setupGame();
                        else
                            disableBut("2",false);
                    }
                }
            });
        }
        this.gui = gui;
        this.game = game;
        this.frame = frame;
        buttonScale();
        visibility(false);
        frame.add(question);
        frame.add(a1);
        frame.add(a2);
        frame.add(a3);
        frame.add(a4);
        if (answers.length>1){
            frame.add(a5);
            frame.add(a6);
            frame.add(a7);
            frame.add(a8);
        }
        isItBet();
        isItChrono(true);
        hasImage(game.getGameSetup()[0].getqS()[0].getImage());
        guipretty=new GUIPretty(game, frame);
        guipretty.makeFab(i,j);
        visibility(true);
    }

    /**
     * This method sets the game every time a question or a round is over.
     */
    public void setupGame() {
        int[] temp;
        label.setVisible(false);
        isItChrono(false);
        visibility(true);
        game.getGameSetup()[i].getqS()[j].setTimeElapsed(timeElapsedGUI);
        temp = game.getGameSetup()[i].getqS()[j].displayQuestion(answers);
        for (int k=0;k<game.getNumberPlayers();k++){
            game.getPlayers()[k].addPoints(temp[k]);
            if (temp[k]==5000 &&game.getGameSetup()[i].getqS()[j] instanceof ThermoQuestion){
                i++;
                j=-1;
            }
        }
        visibility(false);
        if (pivoting()){
            question.setText(game.getGameSetup()[i].getqS()[j].getQuestion());
            a1.setText(game.getGameSetup()[i].getqS()[j].getAnswerArray()[0]);
            a2.setText(game.getGameSetup()[i].getqS()[j].getAnswerArray()[1]);
            a3.setText(game.getGameSetup()[i].getqS()[j].getAnswerArray()[2]);
            a4.setText(game.getGameSetup()[i].getqS()[j].getAnswerArray()[3]);
            if (answers.length==2){
                a5.setText(game.getGameSetup()[i].getqS()[j].getAnswerArray()[0]);
                a6.setText(game.getGameSetup()[i].getqS()[j].getAnswerArray()[1]);
                a7.setText(game.getGameSetup()[i].getqS()[j].getAnswerArray()[2]);
                a8.setText(game.getGameSetup()[i].getqS()[j].getAnswerArray()[3]);
                disableBut("1",true);
                disableBut("2",true);
            }
            for (int k=0;k<answers.length;k++)
                answers[k]=0;
            isItBet();
            isItChrono(true);

            hasImage(game.getGameSetup()[i].getqS()[j].getImage());
            guipretty.makeFab(i,j);
            visibility(true);
            setColor(gui.getColor());
            disableBut(String.valueOf(answers.length),true);
            start=System.currentTimeMillis();
        }
    }

    /**
     * This method checks if the questions(j) of a round(i) are over or if the game is over.
     * @return if the game is over returns false, else true.
     */
    public boolean pivoting()
    {
        j++;
        if (j==game.getQuestions()){
            i++;
            j=0;
        }
        if (i>=game.getRounds()){
            frame.getContentPane().removeAll();
            frame.repaint();
            game.logData("score.txt");
            guipretty.endingScreen(gui.getScoreButton());
            return false;
        }
        return true;
    }

    /**
     * This method sets the visibility of some of the elements displayed.
     * @param set true->visible, false->not visible
     */
    public void visibility(boolean set){
        question.setVisible(set);
        a1.setVisible(set);
        a2.setVisible(set);
        a3.setVisible(set);
        a4.setVisible(set);
        if (answers.length>1){
            a5.setVisible(set);
            a6.setVisible(set);
            a7.setVisible(set);
            a8.setVisible(set);
        }
    }

    /**
     * This method disables/enables the buttons.
     * @param s which set of buttons needs to be disabled/enabled.
     * @param set true->enable, false->disable.
     */
    private void disableBut(String s, boolean set) {
        if (s.equals("1")){
            a1.setEnabled(set);
            a2.setEnabled(set);
            a3.setEnabled(set);
            a4.setEnabled(set);
        }else{
            a5.setEnabled(set);
            a6.setEnabled(set);
            a7.setEnabled(set);
            a8.setEnabled(set);
        }
    }

    /**
     * This method sets the bet from the players.
     */
    private void isItBet(){
        if (game.getGameSetup()[i].getqS()[j] instanceof BetQuestion){
            int[] tempbet = new int[answers.length];
            for (int k=0;k<answers.length;k++){
                JTextField bet = new JTextField("");
                Object[] obj = {"Type of question "+game.getGameSetup()[i].getqS()[j].getCategory()+"\n"+ "Choose the number of points you want to bet! \n 250, 500, 750, 1000\n\n", bet};
                Object[] stringArray= {"Bet!"};
                tempbet[k] = 0;
                while(tempbet[k]!=250 && tempbet[k]!=500 && tempbet[k]!=750 && tempbet[k]!=1000)
                    if(JOptionPane.showOptionDialog(frame, obj, "Choose your betting player "+ (k+1), JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, stringArray, obj) == JOptionPane.OK_OPTION) {
                        tempbet[k] = Integer.parseInt(bet.getText());
                    }
            }
            ((BetQuestion) game.getGameSetup()[i].getqS()[j]).setBetpoints(tempbet);
        }
    }

    /**
     * This method starts or ends the timer if the player is on the chrono mode.
     * @param vis whether the next round needs the timer displayed or not.
     */
    private void isItChrono(boolean vis){
        if (game.getGameSetup()[i].getqS()[j] instanceof ChronoQuestion){
            if (vis){
                time = new TimerWindow();
                time.setTimer();
            }else{
                time.endTimer();
            }
        }
    }

    /**
     * This method sets the size of the buttons.
     */
    private void buttonScale(){
        if (answers.length==1){
            a1.setBounds(320, 250, 210, 50);
            a2.setBounds(620, 250, 210, 50);
            a3.setBounds(320, 320, 210, 50);
            a4.setBounds(620, 320, 210, 50);
        }else{
            a1.setBounds(20, 250, 210, 50);
            a2.setBounds(240, 250, 210, 50);
            a3.setBounds(20, 320, 210, 50);
            a4.setBounds(240, 320, 210, 50);

            a5.setBounds(740, 250, 210, 50);
            a6.setBounds(970, 250, 210, 50);
            a7.setBounds(740, 320, 210, 50);
            a8.setBounds(970, 320, 210, 50);
        }
    }

    /**
     * This method displays the image of a question if it exists.
     * @param path the path of the image.
     */
    private void hasImage(String path){
        icon = new ImageIcon(path);
        label = new JLabel(icon);
        if (!(path.equals("null"))){
            if (answers.length==1)
                label.setBounds(880,200,250,250);
            else
                label.setBounds(470,200,250,250);
            label.setVisible(false);
            frame.add(label);
            label.setVisible(true);
        }
    }

    /**
     * This method sets the color of the buttons after a question.
     * @param c the color of the buttons.
     */
    private void setColor(Color c){
        a1.setBackground(c);
        a2.setBackground(c);
        a3.setBackground(c);
        a4.setBackground(c);
        if (answers.length>1){
            a5.setBackground(c);
            a6.setBackground(c);
            a7.setBackground(c);
            a8.setBackground(c);
        }
    }
}
