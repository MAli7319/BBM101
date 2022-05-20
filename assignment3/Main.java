// Name : Muhammet Ali            // StudentID : b21993073
// Surname : Şentürk              // Assignment3 (Polymorphism, Exceptions)
// Grade:85

import java.util.ArrayList;
import java.util.List;


public class Main {
    
    // To determine the output file name by looking args[2]
    public static String fileName;
    
    // To store the input datas
    public static List<String> initials_input = new ArrayList<>();
    public static List<String> commands_input = new ArrayList<>();
    
    public static void main(String[] args){
        
        ReadInputFiles initials = new ReadInputFiles(args[0]);
        initials_input = initials.getInputread();
        
        ReadInputFiles commands = new ReadInputFiles(args[1]);
        commands_input = commands.getInputread();
        
        fileName = args[2];
        
        // Calling the class which is defined for the entire gameplay
        new Gameplay();
        
    }
    
}
