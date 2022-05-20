// Name : Muhammet Ali                              // Number : 21993073
// Surname : Şentürk                                // Assignment-1 (Encapsulation)

//package assignment1;

import java.util.ArrayList;

public class Main {
    
    // Creating array lists in order to store data
    public static ArrayList<String> author_input;  
    public static ArrayList<String> command_input;  
    
    public static void main(String[] args) {
        
        // Reading the files from terminal and sending them into the array lists
        ReadInputFiles author = new ReadInputFiles(args[0]);  
        author_input = author.getInputread(); 
        
        ReadInputFiles command = new ReadInputFiles(args[1]);
        command_input = command.getInputread();
        
        //  Calling the 
        Commands commands = new Commands();
        
    }
    
}
