package operation;
import book.*;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -04 -15
 * Time: 0:47
 * Description:默认新增到最后一个
 */
public class AddOperation implements IoOperation{
    public void work(BookList bookList) {
        System.out.println("新增图书！");
        System.out.println("请输入你要添加的书籍名称：");
        String name = scanner.nextLine();
        System.out.println("请输入你要添加的书籍作者：");
        String author = scanner.nextLine();
        System.out.println("请输入你要添加的书籍类型：");
        String type = scanner.nextLine();
        System.out.println("请输入你要添加的书籍价格：");
        int price = scanner.nextInt();
        Book bk = new Book(name, author, type, price);
        bookList.setBook(bookList.getUsedSize(), bk);
        bookList.setUsedSize(bookList.getUsedSize()+1);
        System.out.println("新增图书成功");
    }
}
