// Name : Muhammet Ali            // StudentID : b21993073
// Surname : Şentürk              // Assignment4 (Stack, Priority Queue)

import java.util.ArrayList;


public class Main {

    // To determine the output file name by looking args[4]
    public static String fileName;
    
    // To store the input datas
    public static ArrayList<String> parts = new ArrayList<>();
    public static ArrayList<String> items = new ArrayList<>();
    public static ArrayList<String> tokens = new ArrayList<>();
    public static ArrayList<String> tasks = new ArrayList<>();
    
    public static void main(String[] args) {
        
        ReadInputFiles parts_ = new ReadInputFiles(args[0]);
        parts = parts_.getInputread();
        
        ReadInputFiles items_ = new ReadInputFiles(args[1]);
        items = items_.getInputread();
        
        ReadInputFiles tokens_ = new ReadInputFiles(args[2]);
        tokens = tokens_.getInputread();
        
        ReadInputFiles tasks_ = new ReadInputFiles(args[3]);
        tasks = tasks_.getInputread();
        
        fileName = args[4];
        
        // Calling the class which is defined for the entire task
        new Task();
        
    }
    
}
