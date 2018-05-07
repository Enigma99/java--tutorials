package java_input_output;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JavaIOExamples {
    public static void main(String[] args) {

    }

    // read using reader
    public static void readText(){

        try {
            FileReader reader = new FileReader("Animals.txt");

//            reader.

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
