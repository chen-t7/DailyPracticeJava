package IO;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -11 -20
 * Time: 16:46
 */
public class IODemo1 {
    public static void main(String[] args) throws IOException {
        //File file = new File("e:/Amyfile/java/JavaNote/test.txt");
        File file = new File("./test.txt");
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
    }
}
