package IO;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -11 -20
 * Time: 21:05
 */
public class IODemo5 {
    public static void main(String[] args) {
        File file = new File("./test");
        File dest = new File("./testAAA");
        file.renameTo(dest);
    }
}
