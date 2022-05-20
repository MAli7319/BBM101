
//package assignment1;

import java.util.ArrayList;


public class Author {
    
    private String id, name, university, department, email;
    private ArrayList<String> articles = new ArrayList<>();

    // Defining 3 constructors for 3 possible cases
    public Author(String id){
        this.id = id;
        this.name = "    ";
        this.university = "    ";
        this.department = "    ";
        this.email = "    ";
    }
    
    public Author(String id, String name, String university, String department, String email) {
        this.id = id;
        this.name = name;
        this.university = university;
        this.department = department;
        this.email = email;
    }

    public Author(String id, String name, String university, String department, String email, ArrayList<String> articles) {
        this.id = id;
        this.name = name;
        this.university = university;
        this.department = department;
        this.email = email;
        this.articles = articles;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<String> articles) {
        this.articles = articles;
    }    

    @Override
    public String toString() {
        String s = "Author:" + id + "\t" + name + "\t" + university + "\t" + department + "\t" + email;
        for(int i = -1; i < articles.size(); i++){
            if(i <= articles.size() - 1){
                return "\n" + s;
            }
        }
        return s;
        
    }
    

}
