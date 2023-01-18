/**
 * @author Evangelos Chalkias
 * @author Eleni Navrozidou
 * @version 2.0
 * @since 2020
 *
 * The Question class represents a question, its answers and its category.
 *
 */
abstract class Question {
    /**
     *  question is the question.
     */
    private String question;
    /**
     *  answer is the correct answer to the question.
     */
    private String answer;
    /**
     *  answerArray is the array of the three incorrect answers plus the correct one.
     */
    private String[] answerArray;
    /**
     *  category is the category the question belongs to.
     */
    private String category;
    /**
     *  twoPlayerMode is the number of players.
     */
    private int twoPlayerMode;
    /**
     *  timeElapsed is the time taken to answer one question.
     */
    private long[] timeElapsed;
    /**
     *  image is the path of the image to be displayed.
     */
    private String image;

    /**
     *
     * @param twoPlayerMode the number of players.
     */
    public Question(int twoPlayerMode){this.twoPlayerMode=twoPlayerMode;}

    /**
     *
     *This method displays the question on the screen alongside with the answers, waiting for the player to input
     * the answer they think is correct.
     * @param answers are the numbers of the answers each player voted for.
     * @return the number of the answer the player thinks is the correct one.
     */
    public int[] displayQuestion(int [] answers){
        return answers;
    }

    /**
     *
     * @return the correct answer.
     */
    public String getAnswer() { return this.answer; }

    /**
     *
     * @param answer the correct answer.
     */
    public void setAnswer(String answer) {this.answer=answer;}

    /**
     *
     * @return the question.
     */
    public String getQuestion() { return this.question; }

    /**
     *
     * @param question the question.
     */
    public void setQuestion(String question) {this.question=question;}

    /**
     *
     * @return the category.
     */
    public String getCategory() { return this.category; }

    /**
     *
     * @param category the category.
     */
    public void setCategory(String category) {this.category=category;}

    /**
     *
     * @return the possible answers.
     */
    public String[] getAnswerArray() { return this.answerArray; }

    /**
     *
     * @param answerArray the possible answers.
     */
    public void setAnswerArray(String[] answerArray) {this.answerArray=answerArray;}

    /**
     *
     * @return the number of players.
     */
    public int getTwoPlayerMode() {return this.twoPlayerMode;}

    /**
     *
     * @param timeElapsed the time taken to answer one question.
     */
    public void setTimeElapsed(long [] timeElapsed) {this.timeElapsed=timeElapsed;}

    /**
     *
     * @return the time taken to answer one question.
     */
    public long[] getTimeElapsed() {return this.timeElapsed;}

    /**
     *
     * @param image the path of the image.
     */
    public void setImage(String image) {this.image=image;}

    /**
     *
     * @return the path of the image.
     */
    public String getImage() {return image;}
}
