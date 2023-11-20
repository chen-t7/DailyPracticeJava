package IO;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -11 -20
 * Time: 20:28
 */
public class IODemo3 {
    public static void main(String[] args) {
        File file = new File("./test.txt");
        file.delete();
    }
}
