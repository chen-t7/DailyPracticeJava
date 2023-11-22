package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -11 -21
 * Time: 16:37
 */
public class IODemo7 {
    public static void main(String[] args) throws IOException {
        //保证一定能执行到close，但是这种写法不够优雅
//        OutputStream outputStream = null;
//        try {
//            outputStream = new FileOutputStream("e:/Amyfile/java/JavaNote/test.txt");
//            outputStream.write(97);
//            outputStream.write(98);
//            outputStream.write(99);
//            outputStream.write(100);
//        } finally {
//            outputStream.close();
//
//        }

        //更推荐这种写法。这个写法虽然没有显示的写close，实际上是会执行的。只要try语句执行完毕，就可以自动执行到close！！！
        //这个语法，在Java中被称为try with resources：不是随便拿个对象放到try中都可以被释放，得满足一定的要求。
        //必须实现了Closeable接口的类才可以放到try的（）中被自动关闭，这个接口提供的方法就是close方法
        try (OutputStream outputStream = new FileOutputStream("e:/Amyfile/java/JavaNote/test.txt")){
            outputStream.write(97);
            outputStream.write(98);
            outputStream.write(99);
            outputStream.write(100);
        }
    }
}
