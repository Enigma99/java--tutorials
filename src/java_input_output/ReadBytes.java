package java_input_output;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// Read raw bytes serially
public class ReadBytes {
    public static void main(String[] args) {

        readBinary();
        readBinaryUsingBuffer();
    }

    public static void readBinary(){
        try (FileInputStream input = new FileInputStream("Animals.txt")) {

            int readByte;
            while ((readByte = input.read()) != -1){
                System.out.println(readByte);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // more efficient way using chained streams with buffer
    // This is also called Decorator Pattern
    // All read calls are blocking
    public static void readBinaryUsingBuffer(){

        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream("Animals.txt"))) {

            int readByte;
            while ((readByte = input.read()) != -1){
                System.out.println(readByte);
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
