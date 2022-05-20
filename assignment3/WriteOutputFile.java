
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class WriteOutputFile {
    
    // The method that defined static(in order to access this method from other classes easily)
    // writes the output to -filename-.txt
    public static void writeOutput(String s){
        File file = new File(Main.fileName);
        FileWriter fr = null;
        {
        try {
            // Takes an argument "s" and write this argument to this file
            fr = new FileWriter(file, true);
            fr.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }
    }
    
}
