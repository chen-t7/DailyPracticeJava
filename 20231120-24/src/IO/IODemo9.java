package IO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -11 -22
 * Time: 15:18
 */
public class IODemo9 {
    public static void main(String[] args) {
        try (Writer writer = new FileWriter("e:/Amyfile/java/JavaNote/test.txt")) {
            writer.write("hello world");
            //手动刷新缓冲区
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
