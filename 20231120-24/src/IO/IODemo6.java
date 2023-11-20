package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -11 -20
 * Time: 22:11
 */
public class IODemo6 {
    //试用一下字节流读取文件
    public static void main(String[] args) throws IOException {
        //创建InputStream对象的时候，使用绝对路径或者相对路径，都是可以的，也可以使用File对象。
        InputStream inputStream = new FileInputStream("e:/Amyfile/java/JavaNote/test.txt");
        //进行读操作。
        while (true) {
            int b = inputStream.read();
            if (b == -1) {
                //读取完毕
                break;
            }
            System.out.printf("%x \n", (byte)b);
        }
        inputStream.close();
    }
}
