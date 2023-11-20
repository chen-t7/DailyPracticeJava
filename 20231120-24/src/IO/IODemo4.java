package IO;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -11 -20
 * Time: 20:39
 */
public class IODemo4 {
    public static void main(String[] args) {
        File file = new File("./test/aaa/bbb/");
        //mkdir()只能创建一级目录
        //mkdirs()可以创建多级目录
        file.mkdirs();
    }
}