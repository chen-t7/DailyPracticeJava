package IO;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -11 -20
 * Time: 20:20
 */
public class IODemo2 {
    public static void main(String[] args) throws IOException {
        //File file = new File("e:/Amyfile/java/JavaNote/test.txt");
        File file = new File("./test.txt");
        file.createNewFile();
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
    }
}
