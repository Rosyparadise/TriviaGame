
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * @author Eleni Navrozidou
 * @author Vagelis Chalkias
 * @version 2.0
 * @since 2020
 *
 * The Database class keeps all the data needed for the game to run: the questions, the answers, the category.
 *
 */
public class Database {
    /**
     * questionTypes : each node is an ArrayList of strings[], containing the questions and answers of each category.
     */
    private final ArrayList<String[]>[] questionTypes;
    
    /**
     * Initialises the database that all the questions will be stored in and then calls upon createArrays
     */
    public Database() {
        questionTypes = new ArrayList[4];
        ArrayList<String[]> dataFood = new ArrayList<>();
        ArrayList<String[]> dataFilms = new ArrayList<>();
        ArrayList<String[]> dataTech = new ArrayList<>();
        ArrayList<String[]> dataScience = new ArrayList<>();
        this.questionTypes[0] = dataFood;
        this.questionTypes[1] = dataFilms;
        this.questionTypes[2] = dataTech;
        this.questionTypes[3] = dataScience;

        createArrays("test.txt");

    }
    
    /**
     *
     * @param file is the file that the function will get the data from
     * This method collects all the data from a given file and adds it to the corresponding ArrayList according to the category of the question.
     */
    public void createArrays(String file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] prompts = line.split("/");
                switch (prompts[0]){
                    case "Food":
                        this.questionTypes[0].add(prompts);
                        break;
                    case "Films":
                        this.questionTypes[1].add(prompts);
                        break;
                    case "Technology":
                        this.questionTypes[2].add(prompts);
                        break;
                    case "Science":
                        this.questionTypes[3].add(prompts);
                        break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     *
     * @return returns the ArrayList where every category is held.
     */
    public ArrayList<String[]>[] getQuestionTypes() { return questionTypes; }

    /**
     *
     * @param n is the number representing which category's size (how many questions are left in this category) is needed.
     * @return the size - how many questions are left in this category.
     */
    public int getLength(int n) { return this.questionTypes[n].size(); }


}
