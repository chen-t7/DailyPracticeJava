package IO;

import java.io.File;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -11 -22
 * Time: 15:49
 */
public class IODemo11 {
    //扫描指定目录，并找到名称中包含指定字符的所有普通文件（不包含目录），并且后续询问用户是否要
    //删除该文件

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //1.让用户输入一个指定的搜索目录
        //Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要搜索的路径：");
        String basePath = scanner.next();

        //2.针对用户输入进行简单判定
        File root = new File(basePath);
        if (!root.isDirectory()) {
            //路径不存在，或者只是一个普通文件，此时无法进行搜索
            System.out.println("目录不存在！");
            return;
        }

        //3.再让用户输入一个要删除的文件名
        System.out.println("请输入一个要删除的文件名: ");
        String nameToDelete = scanner.next();

        //4.针对指定的路径进行扫描，递归操作
        //先从根目录出发（root），先判定一下，在当前的这个目录里，是否包含要删除的文件，如果是，就删除；否则就跳过下一个
        //如果当前这里包含了一些目录，再针对子目录进行递归
        scanDir(root, nameToDelete);
    }

    private static void scanDir(File root, String nameToDelete) {
        System.out.println("[scanDir] " + root.getAbsolutePath());
        //1.先列出当前路径下包含的内容
        File[] files = root.listFiles();
        if (files == null) {
            //目录为空就返回
            return;
        }
        //2.遍历当前的列出结果
        for (File f : files) {
            if (f.isDirectory()) {
                //如果是目录就进一步递归
                scanDir(f, nameToDelete);
            } else {
                //如果是普通文件，判定是否需要删除
                if (f.getName().contains(nameToDelete)) {
                    System.out.println("请确认是否要删除文件 " + f.getAbsolutePath() + "?");
                    System.out.println("删除：Y  取消删除：N");
                    String s = scanner.next();
                    if (s.equals("Y") || s.equals("y")) {
                        f.delete();
                        System.out.println("删除成功！");
                    } else {
                        System.out.println("取消删除！");
                    }
                }
            }
        }
    }
}
