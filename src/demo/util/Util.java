package demo.util;

public class Util {
    public static int xorAlphas(int data) {

        return Character.isLetter(data) ? data ^ ' ' : data;
        // If its a letter, return data XOR ' ', if not letter, return data

    }
}
