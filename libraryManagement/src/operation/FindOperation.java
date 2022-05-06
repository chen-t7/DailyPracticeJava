package operation;

import book.*;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -04 -15
 * Time: 0:48
 */
public class FindOperation implements IoOperation{
    public void work(BookList bookList) {
        System.out.println("查找图书！");
        System.out.println("请输入你要查找的书籍名称：");
        String name = scanner.nextLine();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getPos(i);
            if (book.getName().equals(name)) {
                System.out.println("找到你要的这本书了");
                System.out.println(book);
                return;
            }
        }
        System.out.println("该图书馆没有你要查找的书籍");
    }
}
