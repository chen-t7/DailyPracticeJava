package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -11 -22
 * Time: 15:40
 */
public class IODemo10 {
    public static void main(String[] args) {
        //System.inq其实是一个输入流对象
        //Scanner scanner = new Scanner(System.in);
        try (InputStream inputStream = new FileInputStream("e:/Amyfile/java/JavaNote/test.txt")){
            Scanner scanner = new Scanner(inputStream);

            //此时读取的内容就是从  文件  进行读取了
            scanner.next();
            //scanner的close本质上是要关闭内部包含的这个流对象，此时内部的inputStream已经被try()关闭了，
            // 所以里面的这个Scanner不关闭也没事
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
