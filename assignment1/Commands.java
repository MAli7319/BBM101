
//package assignment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Commands {
    
    // Accessing the 2 array lists that we created before
    private final ArrayList<String> commands = Main.command_input;
    private final ArrayList<String> authors = Main.author_input;
    
    // Creating new array lists in order to store the data
    public ArrayList<String> article_input = new ArrayList<>(); 
    public static ArrayList<Article> defined_articles = new ArrayList<>();
    public static ArrayList<Author> defined_authors = new ArrayList<>();
    public static ArrayList<String> matched_articles = new ArrayList<>();

    
    public Commands(){
        
        int controller = 0;
        
        for(int i = 0; i < commands.size(); i++){
            if(commands.get(i).split(" ")[0].equals("read")){
                
                // Reading the input file which is given in commands.txt
                ReadInputFiles article = new ReadInputFiles(commands.get(i).split(" ")[1]);
                
                // Adding new data int the array list
                ArrayList<String> new_articles = new ArrayList<>();
                new_articles.addAll(article.getInputread());
                defineArticle(new_articles);  // Calling the method
                if(controller == 0){
                    defineAuthor(authors);
                    
                    // This variable checks if the authors has defined. If yes, then its value is increased 
                    // and therefore it will not more than 1 authors with the same name
                    controller++;
                }
            }
            else if(commands.get(i).equals("completeAll")){
                matchTheArticles(defined_authors);  // Calling the method
            }
            else if(commands.get(i).equals("sortedAll")){
                sortArticle(defined_authors);  // Calling the method
            }
            else if(commands.get(i).split(" ")[0].equals("del")){
                deleteArticle(commands.get(i).split(" ")[1], defined_authors);  // Calling the method
            }
            else{
                if(commands.get(i-1).split(" ")[0].equals("read")){
                    outputDesign(null, defined_authors);  // Calling the method
                }
                else if(commands.get(i-1).equals("completeAll")){
                    outputDesign("CompleteAll", defined_authors);  // Calling the method
                }
                else if(commands.get(i-1).equals("sortedAll")){
                    outputDesign("SortedAll", defined_authors);  // Calling the method
                }
                else if(commands.get(i-1).split(" ")[0].equals("del")){
                    outputDesign("del", defined_authors);  // Calling the method
                }
            }
        }
    }
    
    // This method takes an argument as array list
    // And then it calls the article class in order to define(create) an article object  
    public void defineArticle(ArrayList<String> arrayList){
        
        for(int i = 0; i < arrayList.size(); i++){
            Article new_article = new Article(arrayList.get(i).split(" ")[1], 
                                              arrayList.get(i).split(" ")[2], 
                                              arrayList.get(i).split(" ")[3],
                                              arrayList.get(i).split(" ")[4]);
            defined_articles.add(new_article);
        }
        
    }
    
    // This method takes an argument as array list which contains author objects
    // And then sorts their articles
    public void sortArticle(ArrayList<Author> authors_){
        
        for(int i = 0; i < authors_.size(); i++){
            Collections.sort(authors_.get(i).getArticles());
        }
    }
    
    // This method takes two arguments which is a string and array list which contains author objects
    // And then deletes the articles by looking at the string -which is comes as author id- from array list
    public void deleteArticle(String s, ArrayList<Author> authors_){
        for(int i = 0; i < authors_.size(); i++){
            if(authors_.get(i).getId().equals(s)){
                authors_.get(i).getArticles().clear();
                authors_.remove(authors_.indexOf(authors_.get(i)));
            }
        }
    }
   
    // This method takes two arguments which is a string and array list which contains author objects
    // And then determines the output design
    public void outputDesign(String command, ArrayList<Author> authors_){
        
        // String is determining the first line of the output
        if(command != null){
            WriteOutputFile.writeOutput("**************************************" + command + " Successful**************************************\n");
        }
        
        WriteOutputFile.writeOutput("-----------------------------------------------List-----------------------------------------------");
        
        // Writing the info about authors and articles by using toString method which is defined for that classes 
        for(int i = 0; i < authors_.size(); i++){
            WriteOutputFile.writeOutput(authors_.get(i).toString() + "\n");
            for(int j = 0; j < authors_.get(i).getArticles().size(); j++){                
                for(int k = 0; k < defined_articles.size(); k++){
                    if(defined_articles.get(k).getPaperId().equals(authors_.get(i).getArticles().get(j))){
                        WriteOutputFile.writeOutput(defined_articles.get(k).toString() + "\n");
                    }
                }
            }
        }
        WriteOutputFile.writeOutput("-----------------------------------------------End-----------------------------------------------\n\n");

    }
    
    // This method takes an argument as array list which contains author objects
    // And then matches the articles to their authors when the command says "completeAll"
    // It will stop when the number of articles reached 5 
    public void matchTheArticles(ArrayList<Author> authors_){
        
        for(int j = 0; j < authors_.size(); j++){
            if(authors_.get(j).getArticles().size() != 5){
                for(int i = 0; i < defined_articles.size(); i++){
                    if(defined_articles.get(i).getPaperId().substring(0,3).equals(authors_.get(j).getId()) 
                       && !authors_.get(j).getArticles().contains(defined_articles.get(i).getPaperId())){
                        authors_.get(j).getArticles().add(defined_articles.get(i).getPaperId());
                        if(authors_.get(j).getArticles().size() == 5){
                           break;
                        }
                    }
                }
            }
        }
    }
    
    // This method takes an argument as array list
    // And then it calls the author class in order to define(create) an author object  
    public void defineAuthor(ArrayList<String> arrayList){
                
        // Creating sublists for each line 
        for(int i = 0; i < arrayList.size(); i++){
            String s[] = arrayList.get(i).split(" ");
            List<String> al = new ArrayList<>();
            al = Arrays.asList(s);
            
            // There are 3 possible cases the author can contain the info
            switch (al.size()) {
                
                // Only author id
                case 2:
                    {
                        Author new_author = new Author(al.get(1));
                        defined_authors.add(new_author);
                        break;
                    }
                    
                // Author id, name, university, department and email
                case 6:
                    {
                        Author new_author = new Author(al.get(1), al.get(2), al.get(3), al.get(4), al.get(5));
                        
                        // Checking if the author has been created before
                        // If yes, deleting it and adds the new one
                        for(Author a : defined_authors){
                            if(a.getId().equals(new_author.getId())){
                                defined_authors.remove(a);
                                break;
                            }
                        }
                        defined_authors.add(new_author);
                        break;
                    }
                    
                // Author id, name, university, department, email and articles
                default:
                    {
                        // Creating array list to store the articles  
                        ArrayList<String> match = new ArrayList<>();
                        
                        // Determining the articles which is belongs to the author and adds the array list
                        for(int j = 6; j < al.size(); j++){
                            match.add(al.get(j));
                        }
                        Author new_author = new Author(al.get(1), al.get(2), al.get(3), al.get(4), al.get(5), match);
                        
                        // Checking if the author has been created before
                        // If yes, deleting it and adds the new one
                        for(Author a : defined_authors){
                            if(a.getId().equals(new_author.getId())){
                                defined_authors.remove(a);
                                break;
                            }
                        }
                        
                        defined_authors.add(new_author);
                        break;
                    }
            }
        
        }
        
    }
    
    
    
}
