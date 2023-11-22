package IO;

import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -11 -22
 * Time: 16:37
 */
public class IODemo12 {
    //进行普通文件的复制。把一个文件拷贝成另一个文件。把这个文件按照字节依次读取，把结果写入到另一个文件中
    public static void main(String[] args) {
        //输入两个路径。
        //源  和 目标，（从哪里拷贝到哪里）
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您要拷贝的文件：");
        String srcPath = scanner.next();
        System.out.println("请输入您要拷贝到哪个目录：");
        String destPath = scanner.next();

        File srcFile = new File(srcPath);
        if (!srcFile.isFile()) {
            //是空或者目录都返回
            System.out.println("请输入正确的拷贝文件 ");
            return;
        }

        File destFile = new File(destPath);
        if (destFile.isFile()) {
            //如果文件已经存在
            System.out.println("文件已经存在！");
            return;
        }

        try (InputStream inputStream = new FileInputStream(srcFile);
             OutputStream outputStream = new FileOutputStream(destFile)) {
            while (true) {
                int b = inputStream.read();
                if (b == -1) {
                    break;
                }
                outputStream.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
