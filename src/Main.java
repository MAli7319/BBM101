// Name : Muhammet Ali                              // Number : 21993073
// Surname : Şentürk                                // Assignment-2 (Inheritance)
// Grade:70

import java.util.ArrayList;

public class Main {
    
    // Creating array lists in order to store data
    public static ArrayList<String> people_input;  
    public static ArrayList<String> films_input; 
    public static ArrayList<String> commands_input;
    
    public static void main(String[] args) {
        
        // Reading the input file
        ReadInputFiles people = new ReadInputFiles(args[0]);
        people_input = people.getInputread();
        
        ReadInputFiles films = new ReadInputFiles(args[1]);
        films_input = films.getInputread();
        
        ReadInputFiles commands = new ReadInputFiles(args[2]);
        commands_input = commands.getInputread();
    
        // Main calculations in this class
        Commands commandsClass = new Commands();
    }
    
}
   
