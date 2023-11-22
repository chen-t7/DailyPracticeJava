package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

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
//        while (true) {
//            int b = inputStream.read();
//            if (b == -1) {
//                //读取完毕
//                break;
//            }
//            System.out.printf("%x \n", (byte)b);
//        }
        while (true) {
            byte[] buffer = new byte[1024];
            //buffer在这里是输出型参数
            int len = inputStream.read(buffer);
            System.out.println("len: " + len);
            if (len == -1) {
                break;
            }
            //此时读取的结果被放到了byte中
            for (int i = 0; i < len; i++) {
                System.out.printf("%x\n", buffer[i]);
            }
        }
        inputStream.close();
    }
}
