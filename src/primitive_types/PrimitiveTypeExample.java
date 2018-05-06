package primitive_types;


import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class PrimitiveTypeExample {
    public static void main(String[] args) {
        //displayPrimitiveDataTypes();

        displayStringToBinary();

        printEncodingDetails("a");
        printEncodingDetails("€");
        printEncodingDetails("\u1F602");
    }

    private static void displayPrimitiveDataTypes() {
        // the literal on right is "int literal" meaning its represented by int value
        // this is fine as long as the value falls within range of byte which is between -128 and 127.
        // FYI... there is nothing like byte or short literal. It's either int or long
        byte bb = 100;
        short s = 1000;
        int i = -10000;

        // if it falls out side of range, then we get a compiler error. we might then have to insert cast
        // byte b2 = 200; // compiler error

        // the value literal can also be defined as long literal as follows
        // Trailing 'L' can also be a lowercase but it can be confused with number 1
        long l = 1000000L; // L required if value is above int range.

        // 'x' in 0x41 can be uppercase too
        int hex = 0x41; // hexadecimal. h = 65 (4 * 16^1 + 1 * 16^0)

        // 'b' can be uppercase too
        int binary = 0b0100001; // (Java 7) binary. b = 65

        // octal
        int o = 0101;  // 0 = 65

        int intHex = 0x0041;
        System.out.println("0x0401 in Hex: " + intHex);

        int intBinary = 0b01000001;
        System.out.println("0b01000001 in Binary: " + intBinary);

        int intUnderscore = 1_23_456;
        System.out.println("1_23_456 is same as: " + intUnderscore);
    }

    private static void displayStringToBinary() {
        String name = "Gulfam";
        byte[] nameInBytes = name.getBytes();
        for (byte b : nameInBytes) {
            String binValue = Integer.toBinaryString(b);
            if (binValue.length() < 8){
                System.out.println("Chracter " + (char)b + "/"+b+ " is: " + "0" + Integer.toBinaryString(b));

            } else {
                System.out.println("Chracter " + (char)b + "/"+b+ " is: " + Integer.toBinaryString(b));
            }
        }
    }

    public static void printEncodingDetails(String symbol){
        System.out.println("\nSymbol: " + symbol);
        try {
            System.out.println("ASCII:" + Arrays.toString(symbol.getBytes("US-ASCII")));
            System.out.println("ISO-8859-1: " + Arrays.toString(symbol.getBytes("ISO-8859-1")));
            System.out.println("UTF-8: " + Arrays.toString(symbol.getBytes("UTF-8")));
            System.out.println("UTF-16: " + Arrays.toString(symbol.getBytes("UTF-16")));
            System.out.println("UTF-16 BE: " + Arrays.toString(symbol.getBytes("UTF-16BE")));
            System.out.println("UTF-16 LE: " + Arrays.toString(symbol.getBytes("UTF-16LE")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
