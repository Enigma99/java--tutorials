package java_input_output;

import java.io.*;

// process byte-oriented files (i.e. non-text data. e.g. images, audios, etc)
public class WriteBytes {
    public static void main(String[] args) {

        writeByte("writeByteFile.txt");
        writeBytesUsingBuffer("writeByteFileUsingBuffer.txt");

    }

    // grossly inefficient, writing single bytes is way too expensive
    // as each method invocation triggers disk access
    public static void writeByte(String filename){
        try (OutputStream output = new FileOutputStream(filename)) {

            // write byte, the least siginificant byte will be written (8bits)
            // since this methods accepts an int which is 32 bit
            // the remaining 24 bits will be discarded
            output.write(67);
            output.write(68);
            output.write(69);

            // write groups of bytes
            // this internall still relies on write() method
            byte[] byteArray = {70, 72, 74, 80, 85};
            output.write(byteArray, 0, byteArray.length);

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    // Buffering (byte array - default size is 8192 size)
    // Read/write block of bytes into memory buffer (much faster)
    // You can write blocks of bytes into memory buffer then
    // flush all of the data to the disk in one and single IO operation
    // Using BufferedOuputStream which is subclass of FilterOutputStream
    // this inturn sub-class from OutputStream
    public static void writeBytesUsingBuffer(String filename){
        // Chained Streams - Decorator Pattern
        // Also open-close principle -- classes should be open for extension
        // but closed for modification, FileOutputStream here is extended
        try (BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(filename))){
            output.write(67);
            output.write(68);
            output.write(69);

            byte[] byteBuffer = {70, 72, 74, 80, 85};
            output.write(byteBuffer, 0, byteBuffer.length);

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
