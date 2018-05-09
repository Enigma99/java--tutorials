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

    // Buffering (byte array - default size is 8192 size)
    // Read/write block of bytes into memory buffer (much faster)
    // You can write blocks of bytes into memory buffer then
    // flush all of the data to the disk in one and single IO operation
    // Using BufferedInputStream which is subclass of FilterInputStream
    // this in turn sub-class from InputStream
    public static void readBinaryUsingBuffer(){
        // Chained Streams - Decorator Pattern
        // Also open-close principle -- classes should be open for extension
        // but closed for modification, FileInputStream here is extended
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
