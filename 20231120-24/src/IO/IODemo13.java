package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -11 -23
 * Time: 13:42
 */
public class IODemo13 {
    //扫描指定目录，并找到名称或者内容中包含指定字符的所有普通文件（不包含目录）
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您要扫描的目录：");
        String rootDirPath = scanner.next();

        System.out.println("请输入您要查找的关键字：");
        String token = scanner.next();

        File rootDir = new File(rootDirPath);
        if (!rootDir.isDirectory()) {
            System.out.println("请输入正确的目录 ");
            return;
        }

        List<File> result = new ArrayList<File>();
        scanDirWithContent(rootDir, token, result);
        System.out.println("一共查找到了" + result.size() +"个包含指定字符的文件，分别是 ");
        for (File f : result) {
            System.out.println(f.getAbsolutePath());
        }
    }

    private static void scanDirWithContent(File rootDir, String token, List<File> result) {
        File[] files = rootDir.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        for (File f: files) {
            if (f.isDirectory()) {
                scanDirWithContent(f, token, result);
            } else {
                if (isContentContains(f, token)) {
                    result.add(f.getAbsoluteFile());
                }
            }
        }
    }

    private static boolean isContentContains(File f, String token) {
        StringBuilder stringBuilder = new StringBuilder();
        try (InputStream inputStream = new FileInputStream(f);
             Scanner scanner = new Scanner(inputStream, "UTF-8")
        ) {
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
                stringBuilder.append("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.indexOf(token) == -1;
    }
}
