
//package assignment1;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ReadInputFiles {
    
    // Creating the array list in order to store the data
    private ArrayList<String> inputread;
    
    public ReadInputFiles(String fileName){
        this.inputread = new ArrayList<>();
        
	{        
            try (Scanner sc = new Scanner(new FileReader(fileName))) {
                // Writing the file into inputread line by line
                while(sc.hasNextLine()) {
                    String scnext = sc.nextLine();
                    inputread.add(scnext);
                } 
                sc.close();
            }  
            catch(IOException e) {  
            }  
        }
    }

    public ArrayList<String> getInputread() {
        return inputread;
    }
    
}
