import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileAnalizer fa = new FileAnalizer("D:\\test.txt");
        System.out.println(fa.countFrequencyCharacteristic());
        System.out.println(fa.countLetters());
        System.out.println(fa.countWords());
        System.out.println(fa.countLines());
    }
}
