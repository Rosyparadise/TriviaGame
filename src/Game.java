/**
 * @author Eleni Navrozidou
 * @author Evangelos Chalkias
 * @version 2.0
 * @since 2020
 *
 * The Game class creates the game.
 *
 */
public class Game {
    /**
     * gui is the Graphical user interface that will be used to display the game.
     */
    private GUI gui;
    /**
     *  numberPlayers is the number of players playing the game.
     */
    private final int numberPlayers;
    /**
     *  gameSetup creates the rounds and saves the type of game the player chooses to play in each round.
     */
    private final Round[] gameSetup;
    /**
     *  player creates the object of the player.
     */
    private final Player[] players;
    /**
     * number of rounds
     */
    private final int rounds;
    /**
     * number of questions per round
     */
    private int questions;
    /**
     *Creates the question sets and player objects.
     *
     * @param numberP is the number of players playing the game.
     * @param r is the number of rounds.
     * @param q is the number of questions.
     * @param t is the array of game modes the player(s) are to play in each round.
     */
    public Game(String numberP, String r, String q, int[] t){

        this.numberPlayers = Integer.parseInt(numberP);
        this.questions = Integer.parseInt(q);
        this.rounds = Integer.parseInt(r);

        CreateQuestionSet questionProvider;
        questionProvider = new CreateQuestionSet();

        players = new Player[numberPlayers];
        for (int i=0;i<numberPlayers;i++){
            players[i]=new Player();
        }
        gameSetup = new Round[rounds];
        for (int i=0;i<rounds;i++){
            gameSetup[i]= new Round(questionProvider.createHash(questions,t[i]-1, numberPlayers),t[i]-1);
        }
    }

    /**
     * This method sets the scores in the end of the game.
     * @param f name of the file to be edited.
     */
    public void logData(String f){
        int[] scores = new int[numberPlayers];

        for(int i=0;i<numberPlayers;i++)
            scores[i] = players[i].getPoints();
        Score s = new Score(f);
        s.setScores(scores);
    }
   
    /**
     *
     * @return the players object.
     */
    public Player[] getPlayers(){
        return players;
    }

    /**
     *
     * @param gui the games' gui.
     */
    public void setGui(GUI gui){this.gui=gui;}

    /**
     *
     * @return the games' gui.
     */
    public GUI getGui(){return gui;}

    /**
     *
     * @return the gameSetup.
     */
    public Round[] getGameSetup() {return gameSetup;}

    /**
     *
     * @return the number of rounds.
     */
    public int getRounds(){return rounds;}

    /**
     *
     * @return the number of questions.
     */
    public int getQuestions(){return questions;}

    /**
     *
     * @return the number of players.
     */
    public int getNumberPlayers(){return numberPlayers;}
}
