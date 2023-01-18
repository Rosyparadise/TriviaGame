import java.util.Random;
/**
 * @author Evangelos Chalkias
 * @author Eleni Navrozidou
 * @version 2.0
 * @since 2020
 *
 * The CreateQuestionSet class creates the set of questions that will be used for the game.
 *
 */
public class CreateQuestionSet {
    /**
     * link to database
     */
    private Database data = new Database();
    
    /**
     * Class Constructor
     */
    public CreateQuestionSet(){}
    /**
     * This method randomises the array of all the possible answers to a question.
     * @param array : all the possible answers to a question
     *
     * @return the shuffled array
     */
    public String[] randomise(String[] array){
        Random ran = new Random();
        for(int i = 0; i < array.length; ++i) {
            int ranInd = ran.nextInt(array.length);
            String temp = array[ranInd];
            array[ranInd] = array[i];
            array[i] = temp;
        }
        return array;
    }
    /**
     * This method creates each round and its game mode and it randomly chooses
     * a question from the database class.
     * @param type the game mode
     * @param twoPlayerMode number of players
     * @return a random Question object
     */
    public Question pickQuestion(int type,int twoPlayerMode){
        Random r = new Random();
        Question q;
        if (twoPlayerMode>1)
        {
            switch(type) {
                case 0:
                    q = new SimpleQuestion(twoPlayerMode);
                    break;
                case 1:
                    q= new FastQuestion(twoPlayerMode);
                    break;
                case 2:
                    q =  new ThermoQuestion(twoPlayerMode);
                    break;
                case 3:
                    q = new ChronoQuestion(twoPlayerMode);
                    break;
                default:
                    q = new BetQuestion(twoPlayerMode);
            }
        }
        else
        {
            switch(type) {
                case 0:
                    q = new SimpleQuestion(twoPlayerMode);
                    break;
                case 1:
                    q= new ChronoQuestion(twoPlayerMode);
                    break;
                default:
                    q =  new BetQuestion(twoPlayerMode);
            }
        }
        String[] tempAns = new String[4];
        String[] questionDataTemp;
        int n;
        do {n = r.nextInt(data.getQuestionTypes().length); }
        while (data.getLength(n)==0);
        int m = r.nextInt(data.getLength(n));

        questionDataTemp=data.getQuestionTypes()[n].get(m);
        q.setAnswer(questionDataTemp[2]);
        q.setQuestion(questionDataTemp[1]);
        q.setCategory(questionDataTemp[0]);
        q.setImage(questionDataTemp[6]);

        for(int i = 0; i < 4; ++i){
            tempAns[i] = questionDataTemp[i + 2];
        }
        q.setAnswerArray(randomise(tempAns));
        data.getQuestionTypes()[n].remove(m);
        return q;
    }
    /**
     * This method creates the set of unique questions
     *
     * @param quest a random number representing a question
     * @param type game mode
     * @param twoPlayerMode the number of players.
     * @return the set of unique questions
     */
    public Question[] createHash(int quest,int type,int twoPlayerMode) {
        Question[] BundledQuestions;
        if (type==0){
            BundledQuestions = new SimpleQuestion[quest];
        }
        else if (type==1 && twoPlayerMode>1)
            BundledQuestions = new FastQuestion[quest];
        else if (type==2 && twoPlayerMode>1)
            BundledQuestions = new ThermoQuestion[quest];
        else if ((type==3 && twoPlayerMode>1) || (type==1 && twoPlayerMode==1))
            BundledQuestions = new ChronoQuestion[quest];
        else
            BundledQuestions = new BetQuestion[quest];

        for (int i=0;i<quest;i++) {
            BundledQuestions[i]=pickQuestion(type,twoPlayerMode);
        }

        return BundledQuestions;
    }
}
