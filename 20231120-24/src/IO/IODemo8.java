package IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -11 -22
 * Time: 15:13
 */
public class IODemo8 {
    //字符流的操作
    public static void main(String[] args) {
        try (Reader reader = new FileReader("e:/Amyfile/java/JavaNote/test.txt")) {
            while (true) {
                int ch = reader.read();
                if (ch == -1) {
                    break;
                }
                System.out.println("" + (char)ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
